package vn.sunasterisk.realfootball.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel

abstract class ViewModelBaseFragment <VM : AndroidViewModel,VB : ViewDataBinding>: BaseFragment<VB>(){
    protected abstract val viewModel:VM
}
