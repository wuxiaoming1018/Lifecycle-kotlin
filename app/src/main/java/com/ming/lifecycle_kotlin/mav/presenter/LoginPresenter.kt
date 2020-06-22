package com.ming.lifecycle_kotlin.mav.presenter

import android.os.Handler
import android.text.TextUtils
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

class LoginPresenter(fragmentActivity: FragmentActivity) : BasePresenter(fragmentActivity) {

    private var isDestroy:Boolean = false

    fun login(phoneNumber:String,code:String){
        if (TextUtils.isEmpty(phoneNumber)) {
            Toast.makeText(getActivity(),"手机号码不能为空",Toast.LENGTH_SHORT).show()
            return
        }

        if (TextUtils.isEmpty(code)) {
            Toast.makeText(getActivity(),"验证码不能为空",Toast.LENGTH_SHORT).show();
            return
        }

        Handler().postDelayed(Runnable {
            if (isDestroy) {
                Toast.makeText(getActivity(),"this presenter has been destroyed",Toast.LENGTH_SHORT).show()
                return@Runnable
            }
            Toast.makeText(getActivity(),"登陆成功",Toast.LENGTH_SHORT).show()
        },2000)
    }
}