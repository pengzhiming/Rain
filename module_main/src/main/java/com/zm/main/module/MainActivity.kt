package com.zm.main.module

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.zm.common.router.RouterActivityPath
import com.zm.common.router.RouterFragmentPath
import com.zm.main.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by zm on 2018/12/25.
 */
@Route(path = RouterActivityPath.Main.PAGER_MAIN)
class MainActivity : AppCompatActivity(){
    private lateinit var mTabMenus: MutableList<TabMenu>

    class TabMenu(val title: String, val icon: Int, val fragment: Fragment)

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTabMenu()
        setTab()
        initViewPage()
    }

    // 初始化TabMenu
    private fun initTabMenu() {
        mTabMenus = arrayListOf(
                    TabMenu("首页", R.drawable.tab_home_selector, ARouter.getInstance().build(RouterFragmentPath.Home.PAGER_HOME).navigation()?.let { it as Fragment}!!),
                    TabMenu("商城", R.drawable.tab_mall_selector, ARouter.getInstance().build(RouterFragmentPath.Mall.PAGER_MALL).navigation()?.let { it as Fragment}!!),
                    TabMenu("消息", R.drawable.tab_msg_selector, ARouter.getInstance().build(RouterFragmentPath.Msg.PAGER_MSG).navigation()?.let { it as Fragment}!!),
                    TabMenu("我的", R.drawable.tab_mine_selector, ARouter.getInstance().build(RouterFragmentPath.User.PAGER_USER).navigation()?.let { it as Fragment}!!))
    }

    // 初始化底部菜单
    private fun setTab() {
        mTabMenus.forEach { it ->
            val tab: TabLayout.Tab = tabLayout.newTab()
            val rootView: View = layoutInflater.inflate(R.layout.view_tab, null)
            tab.customView = rootView
            // 设置标题
            rootView.findViewById<TextView>(R.id.tabTitle).text = it.title
            // 设置图标
            rootView.findViewById<ImageView>(R.id.tabIcon).setImageResource(it.icon)
            // 添加Tab
            tabLayout.addTab(tab)
        }
    }

    // 初始化ViewPage
    private fun initViewPage() {
        // 设置adapter
        viewPager.adapter = object: FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(p0: Int): Fragment {
                return mTabMenus[p0].fragment
            }

            override fun getCount(): Int {
                return mTabMenus.size
            }
        }
        // viewPage添加监听器
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        // tabLayout添加监听器
        tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))
        // viewPage预加载4个页面
        viewPager.offscreenPageLimit = 4
        // 默认显示第一个
        viewPager.setCurrentItem(0, false)
    }
}