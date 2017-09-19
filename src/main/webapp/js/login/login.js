$(function(){
        //提交，最终验证。
         $('#btn_login').click(function(){
        	//调用表单验证
    		 if(!$loginForm.valid()){
    			 return;
    		 }
             alert("注册成功,密码已发到你的邮箱,请查收.");
         });

        //重置
         $('#res').click(function(){
                $(".formtips").remove(); 
         });
})