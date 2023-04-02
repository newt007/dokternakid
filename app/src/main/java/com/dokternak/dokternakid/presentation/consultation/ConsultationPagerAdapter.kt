package com.dokternak.dokternakid.presentation.consultation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dokternak.dokternakid.presentation.consultation.inbox.InboxConsultationFragment
import com.dokternak.dokternakid.presentation.consultation.sent.SentConsultationFragment

class ConsultationPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null

        when(position) {
            0 -> fragment = InboxConsultationFragment()
            1 -> fragment = SentConsultationFragment()
        }

        return fragment as Fragment
    }

}