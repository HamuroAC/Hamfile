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

//slick
$(document).ready(function () {
	$('.desimg_center').slick({
		slidesToShow: 1,
		slidesToScroll: 1,
		autoplay: true,
		autoplaySpeed: 2000,
		arrows : false
	});
});