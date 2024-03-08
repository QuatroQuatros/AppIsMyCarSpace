package br.com.fiap.buscarvagas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import dev.jahidhasanco.seatbookview.SeatBookView
import dev.jahidhasanco.seatbookview.SeatClickListener
import dev.jahidhasanco.seatbookview.SeatLongClickListener


class ParkingActivity : ComponentActivity() {

    private lateinit var seatBookView: SeatBookView
    private var seats = (
                    "/AAA_AA" +
                    "/RRA_RR" +
                    "/______" +
                    "/UUA_RR" +
                    "/URA_AA" +
                    "/______" +
                    "/ARU_UA" +
                    "/UUA_RR"
            )


    private var title = listOf(
        "/", "A1", "A2", "A3", "", "B1", "B2",
        "/", "A4", "A5", "A6", "", "B3", "B4",
        "/", "", "", "", "", "", "",
        "/", "C1", "C2", "C3", "", "D1", "D2",
        "/", "C4", "C5", "C6", "", "D3", "D4",
        "/", "", "", "", "", "", "",
        "/", "E1", "E2", "E3", "", "F1", "F2",
        "/", "E4", "E5", "E6", "", "F3", "F4"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.parking_activity)
        seatBookView = findViewById(R.id.layoutSeat)
        seatBookView.setSeatsLayoutString(seats)
            .isCustomTitle(true)
            .setCustomTitle(title)
            .setSeatLayoutPadding(2)
            .setSeatSizeBySeatsColumnAndLayoutWidth(6, -1)
        //ParentLayoutWeight -1 if Your seatBookView layout_width = match_parent / wrap_content


        seatBookView.show()



        seatBookView.setSeatClickListener(object : SeatClickListener {

            override fun onAvailableSeatClick(selectedIdList: List<Int>, view: View) {

            }

            override fun onBookedSeatClick(view: View) {

            }

            override fun onReservedSeatClick(view: View) {

            }


        })

        seatBookView.setSeatLongClickListener(object : SeatLongClickListener {

            override fun onAvailableSeatLongClick(view: View) {
                Toast.makeText(this@ParkingActivity, "Long Pressed", Toast.LENGTH_SHORT).show()
            }

            override fun onBookedSeatLongClick(view: View) {

            }

            override fun onReservedSeatLongClick(view: View) {

            }
        })
    }

    fun goBackToHome(view: View?) {
        val intent: Intent = Intent(this, MainActivity::class.java)
        ContextCompat.startActivity(this, intent, null)
    }
}

