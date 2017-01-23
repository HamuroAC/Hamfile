$(function(){
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
