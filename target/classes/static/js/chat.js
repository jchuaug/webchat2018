var stompClient = null;
var E = window.wangEditor;
var editor = new E(document.getElementById('editor'));
editor.customConfig.menus = [
	'head', // 标题
	'bold', // 粗体
	'fontSize', // 字号
	'fontName', // 字体
	'italic', // 斜体
	'underline', // 下划线
	'foreColor', // 文字颜色
	'link', // 插入链接
	'emoticon', // 表情
	'image' // 插入图片
]
editor.create();
var user_id = ""
var user_name = ""
var friend_name = ""
var user_avator = ""
var friends_avator = ""
var to = "";
var from = "";
var message = ""
var timestamp = ""
var avatar_url = ""
var stompClient = null;

/**
 * 按下Ctrl+enter发送消息
 * @param key_event
 */
function key_send(key_event) {
	if(key_event.ctrlKey && key_event.keyCode == 13) {
		send_msg()
	}

}
/**
 * 时间格式化
 * @param {Object} fmt
 */
Date.prototype.format = function(fmt) {
	var o = {
		"M+": this.getMonth() + 1, //月份
		"d+": this.getDate(), //日
		"h+": this.getHours(), //小时
		"m+": this.getMinutes(), //分
		"s+": this.getSeconds(), //秒
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度
		"S": this.getMilliseconds() //毫秒
	};
	if(/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for(var k in o) {
		if(new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}

function send_msg() {
	message = editor.txt.text();
	timestamp = new Date().format("yyyy-MM-dd hh:mm:ss");
//	to = $(".m_list li.active p").text();
	html_str = "<ul><li><p class='time'><span>" + timestamp + "<//span><//p>" +
		"<div class='m_main_r'>" +
		"<div class='text_r'>" + message + "</div>" +
		"<img src='" + user_avator + "'class='avator_r' //><//div><//li><//ul>";
	$(".m_message").append(html_str);
	$(".m_message").scrollTop(400);

	sendName();
	editor.txt.clear();
}

function connect(from) {
	var socket = new SockJS('/endpoint-webchat2018');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		console.log('Connected: ' + frame);
		stompClient.subscribe('/chat/single/' + from, function(result) {
			showContent(JSON.parse(result.body));
		});
	});
}

//断开连接
function disconnect() {
	if(stompClient !== null) {
		stompClient.disconnect();
	}
	console.log("Disconnected");
}

//显示聊天记录
function showContent(body) {
	if(body.from==to){
		html_str = "<ul><li> <p class='time'><span>" + body.time + "</span></p> <div class='m_main_l'>" +
		"<img src='"+friends_avator+"' class='avator_l' />" +
		"<div class='text_l'>" + body.content + "</div> </div> </li> </ul>";

	// html_str = "<ul><li><p class='time'><span>" + body.time + "<//span><//p>" +
	// 	"<div class='m_main_r'>" +
	// 	"<div class='text_r'>" + body.content + "</div>" +
	// 	"<img src='img//1 (1).jpg' alt='' class='avator_r' //><//div><//li><//ul>";
	$(".m_message").append(html_str);
	$(".m_message").scrollTop(400);
	}
	else{
		console.log("信息对象不符合");
	}
}

function sendName() {
	//	to = $(".m_list li.active p").text();
	//	form=$(".m_card .name").text();
	stompClient.send("/app/single/chat", {}, JSON.stringify({
		'content': message,
		'time': timestamp,
		'to': to,
		'from': from
	}));
}

/**
 * 显示好友列表
 */
function showContact() {
	/**
	 * 发请求获取用户最近联系人列表
	 */
	$.ajax({
		type: 'get',
		url: '/me/listContact',
		data: {
			"id": user_id
		},
		success: function(result) {
			for(var i = 0, l = result.length; i < l; i++) {
				name = result[i]["username"];
				avatar_url = result[i]["avatarLocation"];
				//						alert(name+avatar_url);
				str_content = "<li><img src='" + avatar_url + "' class='avator' />" +
					"<p class='name'>" + name + "</p></li>";
				$(".display_friends").append(str_content);

			}
		}
	});
}
/**
 * 显示最近联系
 */
function showRecentContact() {
	/**
	 * 发请求获取用户最近联系人列表
	 */
	$.ajax({
		type: 'get',
		url: '/me/listRecentContact',
		data: {
			"id": user_id
		},
		success: function(result) {
			for(var i = 0, l = result.length; i < l; i++) {
				name = result[i]["username"];
				avatar_url = result[i]["avatarLocation"];
				str_content = "<li><img src='" + avatar_url + "' class='avator' />" +
					"<p class='name'>" + name + "</p></li>";
				$(".display_friends").append(str_content);

			}
		}
	});

}

function showChatMessage() {

	$.ajax({
		type: 'get',
		url: '/me/listRecentChatMessage',
		data: {
			"username": user_name,
			"friendname": friend_name
		},
		success: function(result) {
			for(var i = 0, l = result.length; i < l; i++) {
				var html_str=''
				if(user_name == result[i]["from"]) {
					/**
					 *自己发送的消息
					 */
					var message = result[i]["content"];
					var timestamp = result[i]["timestamp"]
					html_str = "<ul><li><p class='time'><span>" + timestamp + "<//span><//p>" +
						"<div class='m_main_r'>" +
						"<div class='text_r'>" + message + "</div>" +
						"<img src='" + user_avator + "'class='avator_r' //><//div><//li><//ul>";
				} else {
					var message = result[i]["content"];
					var timestamp = result[i]["timestamp"]
					html_str = "<ul><li> <p class='time'><span>" + timestamp + "</span></p> <div class='m_main_l'>" +
						"<img src='"+friends_avator+"' class='avator_l' />" +
						"<div class='text_l'>" + message + "</div> </div> </li> </ul>";

				}
				$(".m_message").append(html_str);
				$(".m_message").scrollTop(400);

			}
		}
	});

}
/**
 * 显示我的收藏
 */
function showCollections() {}


$("#recent_chat").on("click", showRecentContact());
$("#contact").on("click", showContact());
$("#collection").on("click", showCollections());
$(".display_friends").on("click", "li", function() {
	
	friend_name = $(this).children('p').text();
	to=friend_name;
	friends_avator = $(this).children('img')[0].src;
	$(".m_message_header").css("display", "block");
	$(".m_message_header span").text(friend_name);
	$(".m_message").empty();
	showChatMessage();
});


$(function() {
	/**
	 * 页面加载时候自动建立连接
	 */
	user_name = $.cookie("name");
	user_id = $.cookie("user_id");
	user_avator = $.cookie("user_avator");
	if(name == undefined || user_id == undefined) {
		alert("登录失效，请重新登录");
		window.location.href = "/login.html";
	} else {
		$(".m_card .name").text(user_name);
		$(".m_card .avator").attr("src",user_avator);
		$.ajax({
			type: 'get',
			url: '/me/listRecentContact',
			data: {
				"id": user_id
			},
			success: function(result) {
				for(var i = 0, l = result.length; i < l; i++) {
					name = result[i]["username"];
					url_avator = result[i]["avatarLocation"];
					//						alert(name+avatar_url);
					str_content = "<li><img src='" + url_avator + "' class='avator' />" +
						"<p class='name'>" + name + "</p></li>";
					$(".display_friends").append(str_content);

				}
			}
		});
		from = user_name;

		connect(from); //上线

	}

});