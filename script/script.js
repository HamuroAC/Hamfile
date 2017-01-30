//絵のスクロール
document.addEventListener("DOMContentLoaded", function () {
  [].forEach.call(document.querySelectorAll('.dropimage'), function (img) {
		img.onchange = function (e) {
			var inputfile = this,
				reader = new FileReader();
			reader.onloadend = function () {
				inputfile.style['background-image'] = 'url(' + reader.result + ')';
			}
			reader.readAsDataURL(e.target.files[0]);
		}
	});
});
//モーダルをキーボード操作
document.onkeydown = function (e) {
	if (e.keyCode == 27) {
		var mods = document.querySelectorAll('.modal > [type=checkbox]');
    [].forEach.call(mods, function (mod) {
			mod.checked = false;
		});
	}
}

//利用規約判定
function check() {
	if (document.getElementById("p_checkbox").checked) {
		return true; //送信実行
	} else {
		alert("利用規約に同意してください");
		return false; // 送信中止
	}
}

$(function(){
	var clipboard = new Clipboard('#foo');
	$('#editsubmit').on('click',function(){
		var self = $('#self').val();
		var editname = $('#editname').val();
		if(self.length == 0){
			alert("自己紹介を入力してください。");
			return false;
		}else if(editname.length == 0){
			alert("名前を入力してください。");
			return false;
		}else{
			return true;
		};
	});
});

$(function(){
	$('.add_account_button').on('click',function(){
		var signupId = $('#signupId').val();
		var signupPass = $('#signupPass').val();
		if(signupId.length == 0){
			alert("IDを入力してください。");
			return false;
		}else if(signupPass.length == 0){
			alert("パスワードを入力してください。");
			return false;
		}else{
			return true;
		};
	});
});