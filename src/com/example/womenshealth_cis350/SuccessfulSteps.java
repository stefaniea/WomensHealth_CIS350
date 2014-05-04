package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SuccessfulSteps extends Activity {
	static TextView title;
	static TextView content;
	static Button btn;
	String[] content_strings;
	String[] title_strings;
	int page;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.successful_steps);
		title = (TextView) this.findViewById(R.id.title_step);
		content = (TextView) this.findViewById(R.id.step_content);
		btn = (Button) this.findViewById(R.id.step_button);

		String x = " <p>Rooming-in is when you and your baby remain together " +
				"        for 24 hrs a day after your baby is born [picture]\n</p>" +
				"<font color='#EA8976'><b><i>Why should I room in with my baby?</i></b></font>  \n" +
				"<br> Mothers who room-in with their babies \n</br>" +
				"	<br>\to Make more milk \n</br>" +
				"	<br>\to Make more milk sooner \n</br>" +
				"	<br>\to Breastfeed longer\n</br>" +
				"<br>- Babies who room-in with their mothers \n</br>" +
				"	<br>\to Are more likely to exclusively breastfeed \n</br>" +
				"	<br>\to Cry less \n</br>" +
				"	<br>\to Soothe more easily \n</br>" +
				"	<br>\to Spend more time quietly sleeping \n</br>" +
				"	<br>\to Take in more breast milk \n</br>" +
				"	<br>\to Are less likely to develop jaundice \n</br>" +
				"	</p></font>" +
				"<p><font color='#EA8976'><b><i>Won't I lose sleep if I have my baby with me 24 hours a day?\n</i></b></font>" +
				"<br>\t Studies show that mothers and babies who room in get the same amount " +
				"of sleep as those whose babies are cared for in the nursery  \n</br>" +
				"<br>\t Some moms may even sleep more peacefully knowing their babies are with them \n</br></p>" +
				"<p><font color='#EA8976'><b><i>Doesn't my baby have to go to the nursery for tests and procedures? \n</i></b></font>" +
				"<br>\t Many tasks like vitals signs, baths and blood draws can be done right in" +
				"your room.  Just make sure to ask your nurse if this is possible. \n </br>" +
				"<br>\t Some procedures, such as a circumcision, may require that your baby" +
				"leave your room, but be sure to ask for the baby to be returned to you as " +
				"soon after the procedure as is safe. \n </br>" +
				"<br>\to Did you know that breastfeeding can sooth an infant who is in " +
				"pain?! After a circumcision is a great time to breastfeed your " +
				"baby. \n</br></p>" +
				" <p>\t Ask your provider before you give birth if the place you plan to deliver" +
				"has a policy on rooming-in and how they can help you achieve 24 hours of" +
				"rooming-in with your baby \n</p>" +
				"<p><font color='#EA8976'><b><i>The Bottom Line \n</i></b></font>" +
				"<br>\t Rooming-in is best for mothers and babies to develop a successful " +
				"breastfeeding relationship and should be done as long as the medical " +
				"conditions of the mother and baby allow for it \n</br></p>" +
				"</string>";
		content.setText(Html.fromHtml(x));
		title.setText(R.string.title_rooming_in);
		//content.setText(R.string.content_rooming_in);
		page = 0;

	}

	public boolean onNextStep(View v) {
		if (page == 0) {

			String x = "<p><br>  <font color='#EA8976'><b>Feeding on demand</b></font> means that your baby has unrestricted access to your" +  
					"breasts and you allow them to feed when they are hungry \n </br></p>" + 
					"<p><br><font color='#EA8976'><b><i>Is there a way to know how many times my baby should eat throughout the day? \n</i></b></font></br>" + 
					"<br>\t Although the exact patterns will vary greatly between babies, it is " + 
					"recommended that all babies feed 8-12 times per 24hr day in the first " + 
					"several weeks of life \n</br>" + 
					"<br>\t While some babies may choose to cluster their feeds every hour for " + 
					"several hours during the day, and then space out their feeds to every 3-" + 
					"4 hours over night, other babies may do the exact opposite! Either way is " + 
					"normal! \n</br>" + 
					"<br>\t The key is that your baby feed 8-12 times per day and not go longer than " + 
					"4 hours without offering your baby the breast \n</br></p>" + 
					"<p><br><font color='#EA8976'><b><i>Why is feeding on demand so important? \n</i></b></font></br>" + 
					"<br>\t Feeding on demand will allow your baby to regulate his or her own food " + 
					"intake based on their small, but growing belly\n</br>" + 
					"<br>\t Babies who nurse frequently in the early days of breastfeeding are more " + 
					"likely to bring in their mom's milk supply sooner\n</br>" + 
					"<br>\t Limiting feeds by trying to put your baby on a schedule can lead to a " + 
					"reduced milk supply and further breastfeeding complications\n</br></p>" + 
					"<p><br><font color='#EA8976'><b><i>The Bottom Line \n</i></b></font></br>" + 
					"<br>\t  Watch the baby, not the clock! Get to know your baby's feeding cues and" + 
					"allow the baby to nurse when he or she seems ready. Babies cannot tell " + 
					"time, so trying to put them on a schedule will only stress you and your " + 
					"baby out. Its important not that a baby go 2-3 hours between feedings, " + 
					"but that they get the correct number of feedings overall.</br></p>" + 
					"</string>";

			content.setText(Html.fromHtml(x));

			title.setText(R.string.title_feeding);
			btn.setText(R.string.next_step);
			page++;

		}
		else if (page == 1) {
			String x = "<p> Your baby should be placed <font color='#EA8976'><b> skin-to-skin </b></font> with you as soon as possible after" +  	
					"birth if both you and your baby are medically stable \n" +
					"	<br>\to Make sure to ask your healthcare provider about skin-to-skin " +
					"		before you have your baby so everyone is aware of your wishes \n" +
					"		</br></p>" +
					"<p> Skin-to-skin should also be done with each breastfeeding attempt " +
					"throughout the first few days after birth\n</p>" +
					"<p><font color='#EA8976'><b><i>What are the benefits of skin-to-skin?</i></b></font>" +
					"<br> Babies who are placed skin-to-skin on their mothers immediately after " +
					"birth \n</br>" +
					"<br>\to Cry less \n</br>" +
					"<br>\to Stay warmer\n</br>" +
					"<br>\to Have more stable blood sugars \n</br>" +
					"<br>\to Breastfeed sooner after birth \n</br>" +
					"<br>\to Are more likely to leave the hospital exclusively breastfeeding \n</br>" +
					"<br>\to Breastfeed for longer durations overall \n</br>" +
					"<br> Frequent skin-to-skin contact in the first few days after birth has been " +
					"shown to \n</br>" +
					"<br>\to Improve overall breastfeeding outcomes \n</br>" +
					"<br>\to Prevent infant weight loss \n</br>" +
					"<br>\to Increase mother's milk supply\n</br>" +
					"<br>\to Promote mother-infant bonding \n</br>" +
					"</p>" +
					"<p><font color='#EA8976'><b><i><br>The Bottom Line</br></i></b></font>" +
					"<br> Think of skin-to-skin as breastfeeding class for your baby: your baby " +
					"is learning a new skill and skin-to-skin is providing them with an " +
					"environment in which they can get to know your touch, smell your milk, " +
					"and have easy access to your breasts for when they are ready</br></p>" +
					"    </string>";

			content.setText(Html.fromHtml(x));

			title.setText(R.string.skinToSkin);
			btn.setText(R.string.next_step);
			page++;

		}
		else if (page == 2) {

			String x = "<p><br>  <font color='#EA8976'><b>  Breastfeeding Exclusivity</b></font> means " +
					"that your baby receives only your milk from the " +
					"time he or she is born </br>" +
					"<br>Colostrum is the only food that healthy, full-term babies need in the first few days " +
					"after birth \n</br>" +
					"<br>	\t A 1 day old baby's stomach is about the size of a small marble or 5-7mL \n</br>" +
					"<br>	\t You can trust that your colostrum is just the right amount for your baby's " +
					"first feedings\n</br>" +
					"</p>" +
					"<p><br>Studies show that infants who receive only their mother's milk in the first few" +
					"days following birth are more successful with breastfeeding, breastfeed for longer " +
					"durations, and are more likely to be exclusively breastfeeding at 6 months of age </br>" +
					"</p>" +
					"<p><br><font color='#EA8976'><b> Why shouldn't I give my baby formula if he or she seems hungry and my milk isn't " +
					"in yet?\n</b></font></br>" +
					"<br>\t Your baby's tummy is fragile and is designed to be coated with your " +
					"colostrum, which protects it from getting damaged. Formula can interfere " +
					"with this natural process and allow your baby's tummy to let bacteria in " +
					"which can be harmful to your baby \n</br>" +
					"<br>\t Babies who receive formula are less likely to breastfeed as frequently, " +
					"which can decrease your milk supply as well as delay the time to when " +
					"your milk comes in\n</br>" +
					"</p>" +
					"<br><font color='#EA8976'><b><i>The Bottom Line \n</i></b></font></br>" +
					"<br>\t Trust in the fact that your body was designed to do this for you and your" +
					"baby. You are capable of providing all the nutrition that your baby needs.\n</br>" +
					"</string>";

			content.setText(Html.fromHtml(x));
			title.setText(R.string.title_exclusivity);
			btn.setText(R.string.next_step);
			page++;
		}
		else if (page == 3) {
			
			String x = "<p><br> When trying to establish breastfeeding, it is best to avoid giving your baby a" +
					"pacifier \n</br></p>" +

					"<p><br><font color='#EA8976'><b><i>Why should I avoid giving my baby a pacifier? \n</i></b></font></br>" +
						"<br>\t Pacifiers may cause the baby to skip a feeding or delay time between " +
						"feedings because the babies instinct to suck is being satisfied with an " +
						"artificial nipple \n</br>" +
						"<br>\t Your baby may have difficulty latching to your nipple properly after " +
						"having a pacifier because of the different shape and texture - this is called " +
						"nipple confusion \n</br>" +
						"<br>\t Nipple confusion may also lead to sore nipples and ineffective milk " +
						"transfer \n</br></p>" +
						
					"<p><br><font color='#EA8976'><b><i>When can I consider giving a pacifier to my baby?\n</i></b></font></br>" +
						"<br>\t Most experts recommend waiting at least 4 weeks to introduce a pacifier" +
						"to allow your milk supply to establish itself and ensure your baby is " +
						"breastfeeding frequently enough \n</br>" +
						"<br>\t Even better would be to wait 6-8 weeks, so that your milk supply is " +
						"fully established and you aren't losing any of the much needed nipple" +
						"stimulation to the baby sucking on a pacifier instead of breastfeeding \n</br></p>" +
						"</string>";
			content.setText(Html.fromHtml(x));
			title.setText(R.string.title_pacifier);
			btn.setText(R.string.back_first_step);
			page++;
		}
		else if (page == 4) {
			page = 0;

			String x = " <p>Rooming-in is when you and your baby remain together " +
					"        for 24 hrs a day after your baby is born [picture]\n</p>" +
					"<font color='#EA8976'><b><i>Why should I room in with my baby?</i></b></font>  \n" +
					"<br> Mothers who room-in with their babies \n</br>" +
					"	<br>\to Make more milk \n</br>" +
					"	<br>\to Make more milk sooner \n</br>" +
					"	<br>\to Breastfeed longer\n</br>" +
					"<br> Babies who room-in with their mothers \n</br>" +
					"	<br>\to Are more likely to exclusively breastfeed \n</br>" +
					"	<br>\to Cry less \n</br>" +
					"	<br>\to Soothe more easily \n</br>" +
					"	<br>\to Spend more time quietly sleeping \n</br>" +
					"	<br>\to Take in more breast milk \n</br>" +
					"	<br>\to Are less likely to develop jaundice \n</br>" +
					"	</p></font>" +
					"<p><font color='#EA8976'><b><i>Won't I lose sleep if I have my baby with me 24 hours a day?\n</i></b></font>" +
					"<br>\t Studies show that mothers and babies who room in get the same amount " +
					"of sleep as those whose babies are cared for in the nursery  \n</br>" +
					"<br>\t Some moms may even sleep more peacefully knowing their babies are with them \n</br></p>" +
					"<p><font color='#EA8976'><b><i>Doesn't my baby have to go to the nursery for tests and procedures? \n</i></b></font>" +
					"<br>\t Many tasks like vitals signs, baths and blood draws can be done right in" +
					"your room.  Just make sure to ask your nurse if this is possible. \n </br>" +
					"<br>\t Some procedures, such as a circumcision, may require that your baby" +
					"leave your room, but be sure to ask for the baby to be returned to you as " +
					"soon after the procedure as is safe. \n </br>" +
					"<br>\to Did you know that breastfeeding can sooth an infant who is in " +
					"pain?! After a circumcision is a great time to breastfeed your " +
					"baby. \n</br></p>" +
					" <p>\t Ask your provider before you give birth if the place you plan to deliver" +
					"has a policy on rooming-in and how they can help you achieve 24 hours of" +
					"rooming-in with your baby \n</p>" +
					"<p><font color='#EA8976'><b><i>The Bottom Line \n</i></b></font>" +
					"<br>\t Rooming-in is best for mothers and babies to develop a successful " +
					"breastfeeding relationship and should be done as long as the medical " +
					"conditions of the mother and baby allow for it \n</br></p>" +
					"</string>";
			content.setText(Html.fromHtml(x));
			title.setText(R.string.title_rooming_in);
			btn.setText(R.string.next_step);
		}

		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.changeavatarname :
	        Intent start = new Intent(this, SetUp.class);
			startActivity(start);
	           return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
