package tech.thdev.sample_putextra

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tech.thdev.sample_putextra.constant.Constant
import tech.thdev.sample_putextra.data.SampleData
import tech.thdev.sample_putextra.view.extra.ExtraActivity
import tech.thdev.sample_putextra.view.parcelable.ParcelableActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_extra.setOnClickListener {
            val intent = Intent(this, ExtraActivity::class.java)
            intent.putExtra(Constant.KEY_TITLE, "서울숲")
            intent.putExtra(Constant.KEY_MESSAGE, "서울숲 앞")
            intent.putExtra(Constant.KEY_PHOTO, R.drawable.sample_02)
            startActivity(intent)
        }

        // TODO SampleData에 대해서 Parcelable 작성
//        btn_parcelable.setOnClickListener {
//            val data = SampleData("Arc de Triomphe",
//                    "The Arc de Triomphe de l'Étoile (French pronunciation: [aʁk də tʁijɔ̃f də letwal] ( listen), " +
//                            "Triumphal Arch of the Star) is one of the most famous monuments in Paris. It stands in " +
//                            "the centre of the Place Charles de Gaulle (originally named Place de l'Étoile), at the " +
//                            "western end of the Champs-Élysées.[3] It should not be confused with a smaller arch, the" +
//                            "Arc de Triomphe du Carrousel, which stands west of the Louvre. The Arc de Triomphe honours " +
//                            "those who fought and died for France in the French Revolutionary and the Napoleonic Wars, with " +
//                            "the names of all French victories and generals inscribed on its inner and outer surfaces." +
//                            " Beneath its vault lies the Tomb of the Unknown Soldier from World War I.",
//                    R.drawable.sample_03)
//            val intent = Intent(this, ParcelableActivity::class.java)
//            intent.putExtra(Constant.KEY_PARCELABLE_DATA, data)
//            startActivity(intent)
//        }
    }
}
