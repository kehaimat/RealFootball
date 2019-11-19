package vn.sunasterisk.realfootball.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel

abstract class BaseFragment<VM : AndroidViewModel, VB : ViewDataBinding> : Fragment(), BaseView {
    protected abstract val viewModel:VM

    protected lateinit var viewDataBinding: VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, contentViewId, container, false) as VB
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeView(savedInstanceState)
        initializeComponents()
        registerListeners()
    }

    override fun onDestroyView() {
        unregisterListeners()
        super.onDestroyView()
    }

    open fun registerListeners() {}

    open fun unregisterListeners() {}

    /** true if Back button was handled */
    open fun onBackPressed(): Boolean = false

    fun handleBusinessException(throwable: Throwable) {
        (activity as BaseActivity).handleBusinessException(throwable)
    }

    fun handlerError(data: BaseResponse<*>) {
        data.error?.let {
            handleBusinessException(it)
        }
    }
}
