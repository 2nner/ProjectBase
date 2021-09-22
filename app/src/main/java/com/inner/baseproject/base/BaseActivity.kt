package com.inner.baseproject.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.inner.baseproject.libs.nullCheck

abstract class BaseActivity<BindingType: ViewDataBinding, ViewModelType: AndroidViewModel>(
    @LayoutRes private val layoutRes: Int,
    private val viewModelClass: Class<ViewModelType>?
) : AppCompatActivity() {

    lateinit var binding: BindingType
    lateinit var viewmodel: ViewModelType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = DataBindingUtil.setContentView(this, this.layoutRes)
        nullCheck(this.viewModelClass) {
            ViewModelProvider(this).get(it)
        }
    }
}