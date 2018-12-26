package com.zm.mine.module

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.zm.common.router.RouterFragmentPath
import com.zm.mine.R

/**
 * Created by zm on 2018/12/26.
 */
@Route(path = RouterFragmentPath.User.PAGER_USER)
class MineFragment : Fragment(){
    companion object {
        fun newInstance(): Fragment {
            return MineFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mine, null)
    }
}