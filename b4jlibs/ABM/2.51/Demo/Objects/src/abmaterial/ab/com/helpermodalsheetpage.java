package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class helpermodalsheetpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.helpermodalsheetpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.helpermodalsheetpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.WebSocket _ws = null;
public com.ab.abmaterial.ABMPage _page = null;
public com.ab.abmaterial.ABMTheme _theme = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public String _name = "";
public String _abmpageid = "";
public int _mytoastid = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _btn1_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _googleinp = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
com.ab.abmaterial.ABMInput _inp3 = null;
com.ab.abmaterial.ABMInput _inp4 = null;
com.ab.abmaterial.ABMInput _inp5 = null;
com.ab.abmaterial.ABMInput _inp6 = null;
 //BA.debugLineNum = 244;BA.debugLine="Sub btn1_Clicked(Target As String)";
 //BA.debugLineNum = 252;BA.debugLine="Dim myModal As ABMModalSheet = page.ModalSheet(\"m";
_mymodal = _page.ModalSheet("myModal");
 //BA.debugLineNum = 253;BA.debugLine="Dim googleInp As ABMInput = myModal.Content.Compo";
_googleinp = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("googleInp"));
 //BA.debugLineNum = 254;BA.debugLine="googleInp.Text = \"\"";
_googleinp.setText("");
 //BA.debugLineNum = 255;BA.debugLine="Dim Inp1 As ABMInput = myModal.Content.Component(";
_inp1 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("Inp1"));
 //BA.debugLineNum = 256;BA.debugLine="Inp1.Text = \"\"";
_inp1.setText("");
 //BA.debugLineNum = 257;BA.debugLine="Dim Inp2 As ABMInput = myModal.Content.Component(";
_inp2 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("Inp2"));
 //BA.debugLineNum = 258;BA.debugLine="Inp2.Text = \"\"";
_inp2.setText("");
 //BA.debugLineNum = 259;BA.debugLine="Dim Inp3 As ABMInput = myModal.Content.Component(";
_inp3 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("Inp3"));
 //BA.debugLineNum = 260;BA.debugLine="Inp3.Text = \"\"";
_inp3.setText("");
 //BA.debugLineNum = 261;BA.debugLine="Dim Inp4 As ABMInput = myModal.Content.Component(";
_inp4 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("Inp4"));
 //BA.debugLineNum = 262;BA.debugLine="Inp4.Text = \"\"";
_inp4.setText("");
 //BA.debugLineNum = 263;BA.debugLine="Dim Inp5 As ABMInput = myModal.Content.Component(";
_inp5 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("Inp5"));
 //BA.debugLineNum = 264;BA.debugLine="Inp5.Text = \"\"";
_inp5.setText("");
 //BA.debugLineNum = 265;BA.debugLine="Dim Inp6 As ABMInput = myModal.Content.Component(";
_inp6 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("Inp6"));
 //BA.debugLineNum = 266;BA.debugLine="Inp6.Text = \"\"";
_inp6.setText("");
 //BA.debugLineNum = 268;BA.debugLine="page.ShowModalSheet(\"myModal\")";
_page.ShowModalSheet("myModal");
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public String  _btn2_clicked(String _target) throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Sub btn2_Clicked(Target As String)";
 //BA.debugLineNum = 272;BA.debugLine="page.ShowModalSheet(\"fixedsheet\")";
_page.ShowModalSheet("fixedsheet");
 //BA.debugLineNum = 273;BA.debugLine="End Sub";
return "";
}
public String  _btn3_clicked(String _target) throws Exception{
 //BA.debugLineNum = 275;BA.debugLine="Sub btn3_Clicked(Target As String)";
 //BA.debugLineNum = 276;BA.debugLine="page.ShowModalSheet(\"bottomsheet\")";
_page.ShowModalSheet("bottomsheet");
 //BA.debugLineNum = 277;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMModalSheet  _buildbottomsheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _mybottommodal = null;
com.ab.abmaterial.ABMList _list1 = null;
 //BA.debugLineNum = 415;BA.debugLine="Sub BuildBottomSheet() As ABMModalSheet";
 //BA.debugLineNum = 416;BA.debugLine="Dim myBottomModal As ABMModalSheet";
_mybottommodal = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 417;BA.debugLine="myBottomModal.Initialize(page, \"bottomsheet\", Fal";
_mybottommodal.Initialize(_page,"bottomsheet",__c.False,BA.ObjectToString(__c.True),"");
 //BA.debugLineNum = 418;BA.debugLine="myBottomModal.Content.UseTheme(\"modalcontent\")";
_mybottommodal.Content.UseTheme("modalcontent");
 //BA.debugLineNum = 419;BA.debugLine="myBottomModal.Footer.UseTheme(\"modalcontent\")";
_mybottommodal.Footer.UseTheme("modalcontent");
 //BA.debugLineNum = 420;BA.debugLine="myBottomModal.IsDismissible = True";
_mybottommodal.IsDismissible = __c.True;
 //BA.debugLineNum = 423;BA.debugLine="myBottomModal.Content.AddRows(1,True, \"\").AddCell";
_mybottommodal.Content.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 424;BA.debugLine="myBottomModal.Content.BuildGrid 'IMPORTANT once y";
_mybottommodal.Content.BuildGrid();
 //BA.debugLineNum = 427;BA.debugLine="Dim list1 As ABMList";
_list1 = new com.ab.abmaterial.ABMList();
 //BA.debugLineNum = 428;BA.debugLine="list1.Initialize(page, \"list1\", ABM.COLLAPSE_ACCO";
_list1.Initialize(_page,"list1",_abm.COLLAPSE_ACCORDION,"");
 //BA.debugLineNum = 431;BA.debugLine="list1.AddItem(\"S1\", BuildItem(\"S1\", \"Mom\", \"2\", F";
_list1.AddItem("S1",(com.ab.abmaterial.ABMComponent)(_builditem("S1","Mom","2",__c.False)));
 //BA.debugLineNum = 432;BA.debugLine="list1.AddItem(\"S2\", BuildItem(\"S2\", \"Dad\", \"7\", T";
_list1.AddItem("S2",(com.ab.abmaterial.ABMComponent)(_builditem("S2","Dad","7",__c.True)));
 //BA.debugLineNum = 433;BA.debugLine="list1.AddItem(\"S3\", BuildItem(\"S3\", \"Brother\", \"\"";
_list1.AddItem("S3",(com.ab.abmaterial.ABMComponent)(_builditem("S3","Brother","",__c.False)));
 //BA.debugLineNum = 434;BA.debugLine="list1.AddItem(\"S4\", BuildItem(\"S4\", \"Sister\", \"3\"";
_list1.AddItem("S4",(com.ab.abmaterial.ABMComponent)(_builditem("S4","Sister","3",__c.False)));
 //BA.debugLineNum = 436;BA.debugLine="myBottomModal.Content.Cell(1,1).AddComponent(list";
_mybottommodal.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_list1));
 //BA.debugLineNum = 438;BA.debugLine="Return myBottomModal";
if (true) return _mybottommodal;
 //BA.debugLineNum = 439;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMModalSheet  _buildfixedfootersheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
String _message = "";
com.ab.abmaterial.ABMLabel _lbl1 = null;
com.ab.abmaterial.ABMButton _msbtn3 = null;
 //BA.debugLineNum = 484;BA.debugLine="Sub BuildFixedFooterSheet() As ABMModalSheet";
 //BA.debugLineNum = 485;BA.debugLine="Dim myModal As ABMModalSheet";
_mymodal = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 486;BA.debugLine="myModal.Initialize(page, \"fixedsheet\", True, Fals";
_mymodal.Initialize(_page,"fixedsheet",__c.True,BA.ObjectToString(__c.False),"");
 //BA.debugLineNum = 487;BA.debugLine="myModal.Content.UseTheme(\"modalcontent\")";
_mymodal.Content.UseTheme("modalcontent");
 //BA.debugLineNum = 488;BA.debugLine="myModal.Footer.UseTheme(\"modalfooter\")";
_mymodal.Footer.UseTheme("modalfooter");
 //BA.debugLineNum = 489;BA.debugLine="myModal.IsDismissible = False";
_mymodal.IsDismissible = __c.False;
 //BA.debugLineNum = 492;BA.debugLine="myModal.Content.AddRows(1,True, \"\").AddCells12(1,";
_mymodal.Content.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 493;BA.debugLine="myModal.Content.BuildGrid 'IMPORTANT once you loa";
_mymodal.Content.BuildGrid();
 //BA.debugLineNum = 495;BA.debugLine="Dim Message As String = $\"HOW ROBIN HOOD BECAME A";
_message = ("HOW ROBIN HOOD BECAME AN OUTLAW{BR}\n"+"List and hearken, gentlemen,\n"+"That be of free-born blood,\n"+"I shall you tell of a good yeoman, His name was Robin Hood.{BR}\n"+"Robin was a proud outlaw,\n"+"While as he walked on the ground. So courteous an outlaw as he was one Was never none else found.{BR}\n"+"In the days of good King Harry the Second of England--he of the warring sons--there were certain forests in the north country set aside for the King's hunting, and no man might shoot deer therein under penalty of death. These forests were guarded by the King's Foresters, the chief of whom, in each wood, was no mean man but equal in authority to the Sheriff in his walled town, or even to my lord Bishop in his abbey.\n"+"One of the greatest of royal preserves was Sherwood and Barnesdale forests near the two towns of Nottingham and Barnesdale. Here for some years dwelt one Hugh Fitzooth as Head Forester, with his good wife and son Robert. The boy had been born in Lockesley town--in the year 1160, stern records say--and was often called Lockesley, or Rob of Lockesley. He was a comely, well-knit stripling, and as soon as he was strong enough to walk his chief delight was to go with his father into the forest. As soon as his right arm received thew and sinew he learned to draw the long bow and speed a true arrow. While on winter evenings his greatest joy was to hear his father tell of bold Will o' the Green, the outlaw, who for many summers defied the King's Foresters and feasted with his men upon King's deer. And on other stormy days the boy learned to whittle out a straight shaft for the long bow, and tip it with gray goose feathers.\n"+"The fond mother sighed when she saw the boy's face light up at these woodland tales. She was of gentle birth, and had hoped to see her son famous at court or abbey. She taught him to read and to write, to doff his cap without awkwardness and to answer directly and truthfully both lord and peasant. But the boy, although he took kindly to these lessons of breeding, was yet happiest when he had his beloved bow in hand and strolled at will, listening to the murmur of the trees.\n"+"Two playmates had Rob in these gladsome early days. One was Will Gamewell, his father's brother's son, who lived at Gamewell Lodge, hard by Nottingham town. The other was Marian Fitzwalter, only child of the Earl of Huntingdon. The castle of Huntingdon could be seen from the top of one of the tall trees in Sherwood; and on more than one bright day Rob's white signal from this tree told Marian that he awaited her there: for you must know that Rob did not visit her at the castle. His father and her father were enemies. Some people whispered that Hugh Fitzooth was the rightful Earl of Huntingdon, but that he had been defrauded out of his lands by Fitzwalter, who had won the King's favor by a crusade to the Holy Land. But little cared Rob or Marian for this enmity, however it had arisen. They knew that the great green--wood was open to them, and that the wide, wide world was full of the scent of flowers and the song of birds.\n"+"Days of youth speed all too swiftly, and troubled skies come all too soon. Rob's father had two other enemies besides Fitzwalter, in the persons of the lean Sheriff of Nottingham and the fat Bishop of Hereford. These three enemies one day got possession of the King's ear and whispered therein to such good--or evil--purpose that Hugh Fitzooth was removed from his post of King's Forester. He and his wife and Rob, then a youth of nineteen, were descended upon, during a cold winter's evening, and dispossessed without warning. The Sheriff arrested the Forester for treason--of which, poor man, he was as guiltless as you or I--and carried him to Nottingham jail. Rob and his mother were sheltered over night in the jail, also, but next morning were roughly bade to go about their business. Thereupon they turned for succor to their only kinsman, Squire George of Gamewell, who sheltered them in all kindness.\n"+"But the shock, and the winter night's journey, proved too much for Dame Fitzooth. She had not been strong for some time before leaving the forest. In less than two months she was no more. Rob felt as though his heart was broken at this loss. But scarcely had the first spring flowers begun to blossom upon her grave, when he met another crushing blow in the loss of his father. That stern man had died in prison before his accusers could agree upon the charges by which he was to be brought to trial.\n"+"Two years passed by. Rob's cousin Will was away at school; and Marian's father, who had learned of her friendship with Rob, had sent his daughter to the court of Queen Eleanor. So these years were lonely ones to the orphaned lad. The bluff old Squire was kind to him, but secretly could make nothing of one who went about brooding and as though seeking for something he had lost. The truth is that Rob missed his old life in the forest no less than his mother's gentleness, and his father's companionship. Every time he twanged the string of the long bow against his shoulder and heard the gray goose shaft sing, it told him of happy days that he could not recall.\n"+"One morning as Rob came in to breakfast, his uncle greeted him with, \"I have news for you, Rob, my lad!\" and the hearty old Squire finished his draught of ale and set his pewter tankard down with a crash.\n"+"\"What may that be, Uncle Gamewell?\" asked the young man.\n"+"\"Here is a chance to exercise your good long bow and win a pretty prize. The Fair is on at Nottingham, and the Sheriff proclaims an archer's tournament. The best fellows are to have places with the King's Foresters, and the one who shoots straightest of all will win for prize a olden arrow--a useless bauble enough, but just the thing for your lady love, eh, Rob my boy?\" Here the Squire laughed and whacked the table again with his tankard.\n"+"Rob's eyes sparkled. \"'Twere indeed worth shooting for, uncle mine,\" he said. \"I should dearly love to let arrow fly alongside another man. And a place among the Foresters is what I have long desired. Will you let me try?\"\n"+"\"To be sure,\" rejoined his uncle. \"Well I know that your good mother would have had me make a clerk of you; but well I see that the greenwood is where you will pass your days. So, here's luck to you in the bout!\" And the huge tankard came a third time into play.\n"+"The young man thanked his uncle for his good wishes, and set about making preparations for the journey. He traveled lightly; but his yew bow must needs have a new string, and his cloth-yard arrows must be of the straightest and soundest.\n"+"One fine morning, a few days after, Rob might have been seen passing by way of Lockesley through Sherwood Forest to Nottingham town. Briskly walked he and gaily, for his hopes were high and never an enemy had he in the wide world. But 'twas the very last morning in all his life when he was to lack an enemy! For, as he went his way through Sherwood, whistling a blithe tune, he came suddenly upon a group of Foresters, making merry beneath the spreading branches of an oak-tree. They had a huge meat pie before them and were washing down prodigious slices of it with nut brown ale.\n"+"One glance at the leader and Rob knew at once that he had found an enemy. 'Twas the man who had usurped his father's place as Head Forester, and who had roughly turned his mother out in the snow. But never a word said he for good or bad, and would have passed on his way, had not this man, clearing his throat with a huge gulp, bellowed out: \"By my troth, here is a pretty little archer! Where go you, my lad, with that tupenny bow and toy arrows? Belike he would shoot at Nottingham Fair! Ho! Ho!\"\n"+"A roar of laughter greeted this sally. Rob flushed, for he was mightily proud of his shooting.\n"+"\"My bow is as good as yours,\" he retorted, \"and my shafts will carry as straight and as far. So I'll not take lessons of any of ye\"'\n"+"They laughed again loudly at this, and the leader said with frown:\n"+"\"Show us some of your skill, and if you can hit the mark here's twenty silver pennies for you. But if you hit it not you are in for a sound drubbing for your pertness.\"\n"+"\"Pick your own target,\" quoth Rob in a fine rage. \"I'll lay my head against that purse that I can hit it.\"\n"+"\"It shall be as you say,\" retorted the Forester angrily, \"your head for your sauciness that you hit not my target.\"\n"+"Now at a little rise in the wood a herd of deer came grazing by, distant full fivescore yards. They were King's deer, but at that distance seemed safe from any harm. The Head Forester pointed to them.\n"+"\"If your young arm could speed a shaft for half that distance, I'd shoot with you.\"\n"+"\"Done!\" cried Rob. \"My head against twenty pennies I'll cause yon fine fellow in the lead of them to breathe his last.\"\n"+"And without more ado he tried the string of his long bow, placed a shaft thereon, and drew it to his ear. A moment, and the quivering string sang death as the shaft whistled across the glade. Another moment and the leader of the herd leaped high in his tracks and fell prone, dyeing the sward with his heart's blood.\n"+"A murmur of amazement swept through the Foresters, and then a growl of rage. He that had wagered was angriest of all.\n"+"\"Know you what you have done, rash youth?\" he said. \"You have killed a King's deer, and by the laws of King Harry your head remains forfeit. Talk not to me of pennies but get ye gone straight, and let me not look upon your face again.\"\n"+"Rob's blood boiled within him, and he uttered a rash speech. \"I have looked upon your face once too often already, my fine Forester. 'Tis you who wear my father's shoes.\"\n"+"And with this he turned upon his heel and strode away.\n"+"The Forester heard his parting thrust with an oath. Red with rage he seized his bow, strung an arrow, and without warning launched it full af' Rob. Well was it for the latter that the Forester's foot turned on a twig at the critical instant, for as it was the arrow whizzed by his ear so close as to take a stray strand of his hair with it. Rob turned upon his assailant, now twoscore yards away.\n"+"\"Ha!\" said he. \"You shoot not so straight as I, for all your bravado. Take this from the tupenny bow!\"\n"+"Straight flew his answering shaft. The Head Forester gave one cry, then fell face downward and lay still. His life had avenged Rob's father, but the son was outlawed. Forward he ran through the forest, before the band could gather their scattered wits--still forward into the great greenwood. The swaying trees seemed to open their arms to the wanderer, and to welcome him home.\n"+"Toward the close of the same day, Rob paused hungry and weary at the cottage of a poor widow who dwelt upon the outskirts of the forest. Now this widow had often greeted him kindly in his boyhood days, giving him to eat and drink. So he boldly entered her door. The old dame was right glad to see him, and baked him cakes in the ashes, and had him rest and tell her his story. Then she shook her head.\n"+"\"'Tis an evil wind that blows through Sherwood,\" she said. \"The poor are despoiled and the rich ride over their bodies. My three sons have been outlawed for shooting King's deer to keep us from starving, and now hide in the wood. And they tell me that twoscore of as good men as ever drew bow are in hiding with them.\"\n"+"\"Where are they, good mother?\" cried Rob. \"By my faith, I will join them.\"\n"+"\"Nay, nay,\" replied the old woman at first. But when she saw that there was no other way, she said: \"My sons will visit me to-night. Stay you here and see them if you must.\"\n"+"So Rob stayed willingly to see the widow's sons that night, for they were men after his own heart. And when they found that his mood was with them, they made him swear an oath of fealty, and told him the haunt of the band--a place he knew right well. Finally one of them said:\n"+"\"But the band lacks a leader--one who can use his head as well as his hand. So we have agreed that he who has skill enough to go to Nottingham, an outlaw, and win the prize at archery, shall be our chief.\"\n"+"Rob sprang to his feet. \"Said in good time!\" cried he, \"for I had started to that self-same Fair, and all the Foresters, and all the Sheriff's men in Christendom shall not stand between me and the center of their target!\"\n"+"And though he was but barely grown he stood so straight and his eye flashed with such fire that the three brothers seized his hand and shouted:\n"+"\"A Lockesley! a Lockesley! if you win the golden arrow you shall be chief of outlaws in Sherwood Forest!\"\n"+"So Rob fell to planning how he could disguise himself to go to Nottingham town; for he knew that the Foresters had even then set a price on his head in the market-place.\n"+"It was even as Rob had surmised. The Sheriff of Nottingham posted a reward of two hundred pounds for the capture, dead or alive, of one Robert Fitzooth, outlaw. And the crowds thronging the streets upon that busy Fair day often paused to read the notice and talk together about the death of the Head Forester.\n"+"But what with wrestling bouts and bouts with quarter-staves, and wandering minstrels, there came up so many other things to talk about, that the reward was forgotten for the nonce, and only the Foresters and Sheriff's men watched the gates with diligence, the Sheriff indeed spurring them to effort by offers of largess. His hatred of the father had descended to the son.\n"+"The great event of the day came in the afternoon. It was the archer's contest for the golden arrow, and twenty men stepped forth to shoot. Among them was a beggar-man, a sorry looking fellow with leggings of different colors, and brown scratched face and hands. Over a tawny shock of hair he had a hood drawn, much like that of a monk. Slowly he limped to his place in the line, while the mob shouted in derision. But the contest was open to all comers, so no man said him nay.\n"+"Side by side with Rob--for it was he--stood a muscular fellow of swarthy visage and with one eye hid by a green bandage. Him also the crowd jeered, but he passed them by with indifference while he tried his bow with practiced hand.\n"+"A great crowd had assembled in the amphitheater enclosing the lists. All the gentry and populace of the surrounding country were gathered there in eager expectancy. The central box contained the lean but pompous Sheriff, his bejeweled wife, and their daughter, a supercilious young woman enough, who, it was openly hinted, was hoping to receive the golden arrow from the victor and thus be crowned queen of the day.\n"+"Next to the Sheriff's box was one occupied by the fat Bishop of Hereford; while in the other side was a box wherein sat a girl whose dark hair, dark eyes, and fair features caused Rob's heart to leap. 'Twas Maid Marian! She had come up for a visit from the Queen's court at London town, and now sat demurely by her father the Earl of Huntingdon. If Rob had been grimly resolved to win the arrow before, the sight of her sweet face multiplied his determination an hundredfold. He felt his muscles tightening into bands of steel, tense and true. Yet withal his heart would throb, making him quake in a most unaccountable way.\n"+"Then the trumpet sounded, and the crowd became silent while the herald announced the terms of the contest. The lists were open to all comers. The first target was to be placed at thirty ells distance, and all those who hit its center were allowed to shoot at the second target, placed ten ells farther off. The third target was to be removed yet farther, until the winner was proved. The winner was to receive the golden arrow, and a place with the King's Foresters. He it was also who crowned the queen of the day.\n"+"The trumpet sounded again, and the archers prepared to shoot. Rob looked to his string, while the crowd smiled and whispered at the odd figure he cut, with his vari-colored legs and little cape. But as the first man shot, they grew silent.\n"+"The target was not so far but that twelve out of the twenty contestants reached its inner circle. Rob shot sixth in the line and landed fairly, being rewarded by an approving grunt from the man with the green blinder, who shot seventh, and with apparent carelessness, yet true to the bull's-eye.\n"+"The mob cheered and yelled themselves hoarse at this even marksmanship. The trumpet sounded again, and a new target was set up at forty ells.\n"+"The first three archers again struck true, amid the loud applause of the onlookers; for they were general favorites and expected to win. Indeed 'twas whispered that each was backed by one of the three dignitaries of the day. The fourth and fifth archers barely grazed the center. Rob fitted his arrow quietly and with some confidence sped it unerringly toward the shining circle.\n"+"\"The beggar! the beggar!\" yelled the crowd; \"another bull for the beggar!\" In truth his shaft was nearer the center than any of the others. But it was not so near that \"Blinder,\" as the mob had promptly christened his neighbor, did not place his shaft just within the mark. Again the crowd cheered wildly. Such shooting as this was not seen every day in Nottingham town.\n"+"The other archers in this round were disconcerted by the preceding shots, or unable to keep the pace. They missed one after another and dropped moodily back, while the trumpet sounded for the third round, and the target was set up fifty ells distant.\n"+"\"By my halidom you draw a good bow, young master,\" said Rob's queer comrade to him in the interval allowed for rest. \"Do you wish me to shoot first on this trial?\"\n"+"\"Nay,\" said Rob, \"but you are a good fellow by this token, and if I win not, I hope you may keep the prize from yon strutters.\" And he nodded scornfully to the three other archers who were surrounded by their admirers, and were being made much of by retainers of the Sheriff, the Bishop, and the Earl. From them his eye wandered toward Maid Marian's booth. She had been watching him, it seemed, for their eyes met; then hers were hastily averted.\n"+"\"Blinder's\" quick eye followed those of Rob. \"A fair maid, that,\" he said smilingly, \"and one more worthy the golden arrow than the Sheriff's haughty miss.\"\n"+"Rob looked at him swiftly, and saw naught but kindliness in his glance.\n"+"\"You are a shrewd fellow and I like you well,\" was his only comment.\n"+"Now the archers prepared to shoot again, each with some little care. The target seemed hardly larger than the inner ring had looked, at the first trial. The first three sped their shafts, and while they were fair shots they did not more than graze the inner circle.\n"+"Rob took his stand with some misgiving. Some flecking clouds overhead made the light uncertain, and a handful of wind frolicked across the range in a way quite disturbing to a bowman's nerves. His eyes wandered for a brief moment to the box wherein sat the dark-eyed girl. His heart leaped! she met his glance and smiled at him reassuringly. And in that moment he felt that she knew him despite his disguise and looked to him to keep the honor of old Sherwood. He drew his bow firmly and, taking advantage of a momentary lull in the breeze, launched the arrow straight and true-singing across the range to the center of the target.\n"+"\"The beggar! the beggar! a bull! a bull!\" yelled the fickle mob, who from jeering him were now his warm friends. \"Can you beat that, Blinder?\"\n"+"The last archer smiled scornfully and made ready. He drew his bow with ease and grace and, without seeming to study the course, released the winged arrow. Forward it leaped toward the target, and all eyes followed its flight. A loud uproar broke forth when it alighted, just without the center and grazing the shaft sent by Rob. The stranger made a gesture of surprise when his own eyes announced the result to him, but saw his error. He had not allowed for the fickle gust of wind which seized the arrow and carried it to one side. But for all that he was the first to congratulate the victor.\n"+"\"I hope we may shoot again,\" quoth he. \"In truth I care not for the golden bauble and wished to win it in despite of the Sheriff for whom I have no love. Now crown the lady of your choice.\" And turning suddenly he was lost in the crowd, before Rob could utter what it was upon his lips to say, that he would shoot again with him.\n"+"And now the herald summoned Rob to the Sheriff's box to receive the prize.\n"+"\"You are a curious fellow enough,\" said the Sheriff, biting his lip coldly; \"yet you shoot well. What name go you by?\"\n"+"Marian sat near and was listening intently.\n"+"\"I am called Rob the Stroller, my Lord Sheriff,\" said the archer.\n"+"Marian leaned back and smiled.\n"+"\"Well, Rob the Stroller, with a little attention to your skin and clothes you would not be so bad a man,\" said the Sheriff. \"How like you the idea of entering my service.\n"+"\"Rob the Stroller has ever been a free man, my Lord, and desires no service.\"\n"+"The Sheriff's brow darkened, yet for the sake of his daughter and the golden arrow, he dissembled.\n"+"\"Rob the Stroller,\" said he, \"here is the golden arrow which has been offered to the best of archers this day. You are awarded the prize. See that you bestow it worthily.\"\n"+"At this point the herald nudged Rob and half inclined his head toward the Sheriff's daughter, who sat with a thin smile upon her lips. But Rob heeded him not. He took the arrow and strode to the next box where sat Maid Marian.\n"+"\"Lady,\" he said, \"pray accept this little pledge from a poor stroller who would devote the best shafts in his quiver to serve you.\"\n"+"\"My thanks to you, Rob in the Hood,\" replied she with a roguish twinkle in her eye; and she placed the gleaming arrow in her hair, while the people shouted, \"The Queen! the Queen!\"\n"+"The Sheriff glowered furiously upon this ragged archer who had refused his service, taken his prize without a word of thanks, and snubbed his daughter. He would have spoken, but his proud daughter restrained him. He called to his guard and bade them watch the beggar. But Rob had already turned swiftly, lost himself in the throng, and headed straight for the town gate.\n"+"That same evening within a forest glade a group of men--some twoscore clad in Lincoln green--sat round a fire roasting venison and making merry. Suddenly a twig crackled and they sprang to their feet and seized their weapons.\n"+"\"I look for the widow's sons,\" a clear voice said, \"and I come alone.\"\n"+"Instantly the three men stepped forward.\n"+"\"Tis Rob!\" they cried; \"welcome to Sherwood Forest, Rob!\" And all the men came and greeted him; for they had heard his story.\n"+"Then one of the widow's sons, Stout Will, stepped forth and said:\n"+"\"Comrades all, ye know that our band has sadly lacked a leader--one of birth, breeding, and skill. Belike we have found that leader in this young man. And I and my brothers have told him that the band would choose that one who should bring the Sheriff to shame this day and capture his golden arrow. Is it not so?\"\n"+"The band gave assent.\n"+"Will turned to Rob. \"What news bring you from Nottingham town?\" asked he.\n"+"Rob laughed. \"In truth I brought the Sheriff to shame for mine own pleasure, and won his golden arrow to boot. But as to the prize ye must e'en take my word, for I bestowed it upon a maid.\"\n"+"And seeing the men stood in doubt at this, he continued: \"But I'll gladly join your band, and you take me, as a common archer. For there are others older and mayhap more skilled than I.\"\n"+"Then stepped one forward from the rest, a tall swarthy man. And Rob recognized him as the man with the green blinder; only this was now removed, and his freed eye gleamed as stoutly as the other one.\n"+"\"Rob in the Hood--for such the lady called you,\" said he, \"I can vouch for your tale. You shamed the Sheriff e'en as I had hoped to do; and we can forego the golden arrow since it is in such fair hands. As to your shooting and mine, we must let future days decide. But here I, Will Stutely, declare that I will serve none other chief save only you.\"\n"+"Then good Will Stutely told the outlaws of Rob's deeds, and gave him his hand of fealty. And the widow's sons did likewise, and the other members every one, right gladly; because Will Stutely had heretofore been the truest bow in all the company. And they toasted him in nut brown ale, and hailed him as their leader, by the name of Robin Hood. And he accepted that name because Maid Marian had said it.\n"+"By the light of the camp-fire the band exchanged signs and passwords. They gave Robin Hood a horn upon which he was to blow to summon them. They swore, also, that while they might take money and goods from the unjust rich, they would aid and befriend the poor and the helpless; and that they would harm no woman, be she maid, wife, or widow. They swore all this with solemn oaths, while they feasted about the ruddy blaze, under the greenwood tree.\n"+"{BR}\n"+"And that is how Robin Hood became an outlaw.");
 //BA.debugLineNum = 596;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 597;BA.debugLine="lbl1.Initialize(page, \"contlbl1\", Message,ABM.SIZ";
_lbl1.Initialize(_page,"contlbl1",_message,_abm.SIZE_PARAGRAPH,__c.False,"");
 //BA.debugLineNum = 598;BA.debugLine="myModal.Content.Cell(1,1).AddComponent(lbl1)";
_mymodal.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl1));
 //BA.debugLineNum = 602;BA.debugLine="myModal.Footer.AddRowsM(1,True,0,0, \"\").AddCellsO";
_mymodal.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (9),(int) (9),(int) (9),(int) (3),(int) (3),(int) (3),"");
 //BA.debugLineNum = 603;BA.debugLine="myModal.Footer.BuildGrid 'IMPORTANT once you load";
_mymodal.Footer.BuildGrid();
 //BA.debugLineNum = 606;BA.debugLine="Dim msbtn3 As ABMButton";
_msbtn3 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 607;BA.debugLine="msbtn3.InitializeFlat(page, \"msbtn3\", \"\", \"\", \"Cl";
_msbtn3.InitializeFlat(_page,"msbtn3","","","Close","transparent");
 //BA.debugLineNum = 608;BA.debugLine="myModal.Footer.Cell(1,1).AddComponent(msbtn3)";
_mymodal.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_msbtn3));
 //BA.debugLineNum = 610;BA.debugLine="Return myModal";
if (true) return _mymodal;
 //BA.debugLineNum = 611;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMContainer  _builditem(String _id,String _text,String _messages,boolean _isnew) throws Exception{
com.ab.abmaterial.ABMContainer _itemcont = null;
com.ab.abmaterial.ABMLabel _lbl = null;
com.ab.abmaterial.ABMBadge _badge = null;
 //BA.debugLineNum = 441;BA.debugLine="Sub BuildItem(id As String, text As String, messag";
 //BA.debugLineNum = 442;BA.debugLine="Dim ItemCont As ABMContainer";
_itemcont = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 443;BA.debugLine="ItemCont.Initialize(page, id, \"\")";
_itemcont.Initialize(_page,_id,"");
 //BA.debugLineNum = 444;BA.debugLine="ItemCont.AddRowsM(1,False,0,0, \"\").AddCellsOSMP(1";
_itemcont.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (10),(int) (10),(int) (10),(int) (6),(int) (0),(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (2),(int) (2),(int) (2),(int) (6),(int) (0),(int) (0),(int) (0),"");
 //BA.debugLineNum = 445;BA.debugLine="ItemCont.BuildGrid 'IMPORTANT once you loaded the";
_itemcont.BuildGrid();
 //BA.debugLineNum = 447;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 448;BA.debugLine="lbl.Initialize(page, id & \"lbl\", text, ABM.SIZE_P";
_lbl.Initialize(_page,_id+"lbl",_text,_abm.SIZE_PARAGRAPH,__c.False,"");
 //BA.debugLineNum = 449;BA.debugLine="ItemCont.Cell(1,1).AddComponent(lbl)";
_itemcont.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl));
 //BA.debugLineNum = 451;BA.debugLine="Dim badge As ABMBadge";
_badge = new com.ab.abmaterial.ABMBadge();
 //BA.debugLineNum = 452;BA.debugLine="badge.Initialize(page, id & \"badge\", messages, is";
_badge.Initialize(_page,_id+"badge",_messages,_isnew,"");
 //BA.debugLineNum = 453;BA.debugLine="ItemCont.Cell(1,2).AddComponent(badge)";
_itemcont.Cell((int) (1),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_badge));
 //BA.debugLineNum = 455;BA.debugLine="Return ItemCont";
if (true) return _itemcont;
 //BA.debugLineNum = 456;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMModalSheet  _buildmodalsheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _googleinp = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
com.ab.abmaterial.ABMInput _inp3 = null;
com.ab.abmaterial.ABMInput _inp4 = null;
com.ab.abmaterial.ABMInput _inp5 = null;
com.ab.abmaterial.ABMInput _inp6 = null;
com.ab.abmaterial.ABMEditor _editor = null;
com.ab.abmaterial.ABMRadioGroup _rbgroup = null;
com.ab.abmaterial.ABMButton _msbtn1 = null;
com.ab.abmaterial.ABMButton _msbtn2 = null;
 //BA.debugLineNum = 279;BA.debugLine="Sub BuildModalSheet() As ABMModalSheet";
 //BA.debugLineNum = 280;BA.debugLine="Dim myModal As ABMModalSheet";
_mymodal = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 281;BA.debugLine="myModal.Initialize(page, \"myModal\", False, False,";
_mymodal.Initialize(_page,"myModal",__c.False,BA.ObjectToString(__c.False),"");
 //BA.debugLineNum = 282;BA.debugLine="myModal.Content.UseTheme(\"modalcontent\")";
_mymodal.Content.UseTheme("modalcontent");
 //BA.debugLineNum = 283;BA.debugLine="myModal.Footer.UseTheme(\"modalfooter\")";
_mymodal.Footer.UseTheme("modalfooter");
 //BA.debugLineNum = 284;BA.debugLine="myModal.IsDismissible = False";
_mymodal.IsDismissible = __c.False;
 //BA.debugLineNum = 287;BA.debugLine="myModal.Content.AddRows(1,True, \"\").AddCells12(1,";
_mymodal.Content.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 288;BA.debugLine="myModal.Content.AddRows(2,True, \"\").AddCellsOS(2,";
_mymodal.Content.AddRows((int) (2),__c.True,"").AddCellsOS((int) (2),(int) (0),(int) (0),(int) (0),(int) (6),(int) (6),(int) (6),"");
 //BA.debugLineNum = 289;BA.debugLine="myModal.Content.AddRows(5,True, \"\").AddCells12(1,";
_mymodal.Content.AddRows((int) (5),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 290;BA.debugLine="myModal.Content.BuildGrid 'IMPORTANT once you loa";
_mymodal.Content.BuildGrid();
 //BA.debugLineNum = 293;BA.debugLine="myModal.Content.Cell(1,1).AddComponent(ABMShared.";
_mymodal.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Enter your info so we can contact you later")));
 //BA.debugLineNum = 295;BA.debugLine="Dim googleInp As ABMInput";
_googleinp = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 296;BA.debugLine="googleInp.Initialize(page, \"googleInp\", ABM.INPUT";
_googleinp.Initialize(_page,"googleInp",_abm.INPUT_TEXT,"Search Address via Google",__c.False,"");
 //BA.debugLineNum = 297;BA.debugLine="googleInp.AutoCompleteType = ABM.AUTOCOMPLETE_GOO";
_googleinp.AutoCompleteType = _abm.AUTOCOMPLETE_GOOGLE;
 //BA.debugLineNum = 298;BA.debugLine="myModal.Content.Cell(1,1).AddComponent(googleInp)";
_mymodal.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_googleinp));
 //BA.debugLineNum = 301;BA.debugLine="Dim inp1 As ABMInput";
_inp1 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 302;BA.debugLine="inp1.Initialize(page, \"inp1\", ABM.INPUT_TEXT, \"St";
_inp1.Initialize(_page,"inp1",_abm.INPUT_TEXT,"Street",__c.False,"");
 //BA.debugLineNum = 303;BA.debugLine="inp1.PlaceHolderText = \"Streetname\"";
_inp1.PlaceHolderText = "Streetname";
 //BA.debugLineNum = 304;BA.debugLine="myModal.Content.Cell(2,1).AddComponent(inp1)";
_mymodal.Content.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp1));
 //BA.debugLineNum = 306;BA.debugLine="Dim inp2 As ABMInput";
_inp2 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 307;BA.debugLine="inp2.Initialize(page, \"inp2\", ABM.INPUT_TEXT, \"Nu";
_inp2.Initialize(_page,"inp2",_abm.INPUT_TEXT,"Number",__c.False,"");
 //BA.debugLineNum = 308;BA.debugLine="myModal.Content.Cell(2,2).AddComponent(inp2)";
_mymodal.Content.Cell((int) (2),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp2));
 //BA.debugLineNum = 310;BA.debugLine="Dim inp3 As ABMInput";
_inp3 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 311;BA.debugLine="inp3.Initialize(page, \"inp3\", ABM.INPUT_TEXT, \"Po";
_inp3.Initialize(_page,"inp3",_abm.INPUT_TEXT,"Postal Number",__c.False,"");
 //BA.debugLineNum = 312;BA.debugLine="myModal.Content.Cell(3,1).AddComponent(inp3)";
_mymodal.Content.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp3));
 //BA.debugLineNum = 314;BA.debugLine="Dim inp4 As ABMInput";
_inp4 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 315;BA.debugLine="inp4.Initialize(page, \"inp4\", ABM.INPUT_TEXT, \"Ci";
_inp4.Initialize(_page,"inp4",_abm.INPUT_TEXT,"City",__c.False,"");
 //BA.debugLineNum = 316;BA.debugLine="myModal.Content.Cell(3,2).AddComponent(inp4)";
_mymodal.Content.Cell((int) (3),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp4));
 //BA.debugLineNum = 318;BA.debugLine="Dim inp5 As ABMInput";
_inp5 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 319;BA.debugLine="inp5.Initialize(page, \"inp5\", ABM.INPUT_TEXT, \"Co";
_inp5.Initialize(_page,"inp5",_abm.INPUT_TEXT,"Country",__c.False,"");
 //BA.debugLineNum = 320;BA.debugLine="myModal.Content.Cell(4,1).AddComponent(inp5)";
_mymodal.Content.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp5));
 //BA.debugLineNum = 322;BA.debugLine="Dim inp6 As ABMInput";
_inp6 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 323;BA.debugLine="inp6.Initialize(page, \"inp6\", ABM.INPUT_TEXT, \"Lo";
_inp6.Initialize(_page,"inp6",_abm.INPUT_TEXT,"Location",__c.False,"");
 //BA.debugLineNum = 324;BA.debugLine="myModal.Content.Cell(5,1).AddComponent(inp6)";
_mymodal.Content.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp6));
 //BA.debugLineNum = 326;BA.debugLine="googleInp.SetGoogleAutocompleteResultInputCompone";
_googleinp.SetGoogleAutocompleteResultInputComponent(_inp1,_abm.GOOGLE_AUTOCOMLETE_RESULTTYPE_STREETNAME);
 //BA.debugLineNum = 327;BA.debugLine="googleInp.SetGoogleAutocompleteResultInputCompone";
_googleinp.SetGoogleAutocompleteResultInputComponent(_inp2,_abm.GOOGLE_AUTOCOMLETE_RESULTTYPE_STREETNUMBER);
 //BA.debugLineNum = 328;BA.debugLine="googleInp.SetGoogleAutocompleteResultInputCompone";
_googleinp.SetGoogleAutocompleteResultInputComponent(_inp3,_abm.GOOGLE_AUTOCOMLETE_RESULTTYPE_POSTALCODE);
 //BA.debugLineNum = 329;BA.debugLine="googleInp.SetGoogleAutocompleteResultInputCompone";
_googleinp.SetGoogleAutocompleteResultInputComponent(_inp4,_abm.GOOGLE_AUTOCOMLETE_RESULTTYPE_CITY);
 //BA.debugLineNum = 330;BA.debugLine="googleInp.SetGoogleAutocompleteResultInputCompone";
_googleinp.SetGoogleAutocompleteResultInputComponent(_inp5,_abm.GOOGLE_AUTOCOMLETE_RESULTTYPE_COUNTRY);
 //BA.debugLineNum = 331;BA.debugLine="googleInp.SetGoogleAutocompleteResultInputCompone";
_googleinp.SetGoogleAutocompleteResultInputComponent(_inp6,_abm.GOOGLE_AUTOCOMLETE_RESULTTYPE_LOCATION);
 //BA.debugLineNum = 334;BA.debugLine="Dim editor As ABMEditor";
_editor = new com.ab.abmaterial.ABMEditor();
 //BA.debugLineNum = 335;BA.debugLine="editor.Initialize(page, \"editor\", True, True, \"ed";
_editor.Initialize(_page,"editor",__c.True,__c.True,"editor");
 //BA.debugLineNum = 336;BA.debugLine="myModal.Content.Cell(6,1).AddComponent(editor)";
_mymodal.Content.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_editor));
 //BA.debugLineNum = 338;BA.debugLine="Dim rbgroup As ABMRadioGroup";
_rbgroup = new com.ab.abmaterial.ABMRadioGroup();
 //BA.debugLineNum = 339;BA.debugLine="rbgroup.Initialize( page, \"rbgroup\", \"\")";
_rbgroup.Initialize(_page,"rbgroup","");
 //BA.debugLineNum = 340;BA.debugLine="rbgroup.AddRadioButton(\"Posibility 1\", True)";
_rbgroup.AddRadioButton("Posibility 1",__c.True);
 //BA.debugLineNum = 341;BA.debugLine="rbgroup.AddRadioButton(\"Posibility 2\", True)";
_rbgroup.AddRadioButton("Posibility 2",__c.True);
 //BA.debugLineNum = 342;BA.debugLine="rbgroup.SetActive(1)";
_rbgroup.SetActive((int) (1));
 //BA.debugLineNum = 343;BA.debugLine="myModal.Content.Cell(1,1).AddComponent(rbgroup)";
_mymodal.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_rbgroup));
 //BA.debugLineNum = 364;BA.debugLine="myModal.Footer.AddRowsM(1,True,0,0, \"\").AddCellsO";
_mymodal.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (6),(int) (6),(int) (6),(int) (3),(int) (3),(int) (3),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (3),(int) (3),(int) (3),"");
 //BA.debugLineNum = 365;BA.debugLine="myModal.Footer.BuildGrid 'IMPORTANT once you load";
_mymodal.Footer.BuildGrid();
 //BA.debugLineNum = 368;BA.debugLine="Dim msbtn1 As ABMButton";
_msbtn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 369;BA.debugLine="msbtn1.InitializeFlat(page, \"msbtn1\", \"\", \"\", \"OK";
_msbtn1.InitializeFlat(_page,"msbtn1","","","OK","transparent");
 //BA.debugLineNum = 370;BA.debugLine="myModal.Footer.Cell(1,1).AddComponent(msbtn1)";
_mymodal.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_msbtn1));
 //BA.debugLineNum = 372;BA.debugLine="Dim msbtn2 As ABMButton";
_msbtn2 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 373;BA.debugLine="msbtn2.InitializeFlat(page, \"msbtn2\", \"\", \"\", \"CA";
_msbtn2.InitializeFlat(_page,"msbtn2","","","CANCEL","transparent");
 //BA.debugLineNum = 374;BA.debugLine="myModal.Footer.Cell(1,2).AddComponent(msbtn2)";
_mymodal.Footer.Cell((int) (1),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_msbtn2));
 //BA.debugLineNum = 376;BA.debugLine="Return myModal";
if (true) return _mymodal;
 //BA.debugLineNum = 377;BA.debugLine="End Sub";
return null;
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 115;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 118;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 119;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 120;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 121;BA.debugLine="page.PageTitle = \"ABMModalSheet\"";
_page.PageTitle = "ABMModalSheet";
 //BA.debugLineNum = 122;BA.debugLine="page.PageDescription = \"The modal sheet helper\"";
_page.PageDescription = "The modal sheet helper";
 //BA.debugLineNum = 123;BA.debugLine="page.PageHTMLName = \"abmaterial-modal-sheet.html\"";
_page.PageHTMLName = "abmaterial-modal-sheet.html";
 //BA.debugLineNum = 124;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 125;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 126;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 127;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 129;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMModalSheet";
_abmshared._buildnavigationbar(_page,"ABMModalSheet","../images/logo.png","","Helpers","ABMModalSheet");
 //BA.debugLineNum = 132;BA.debugLine="page.AddRows(7,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (7),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 133;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 136;BA.debugLine="page.GoogleMapsAPIExtras = \"key=AIzaSyCXb4vvFQBYe";
_page.GoogleMapsAPIExtras = "key=AIzaSyCXb4vvFQBYeZVydJ7HQo_I1_mpvOOUs38&libraries=places";
 //BA.debugLineNum = 138;BA.debugLine="page.AddCanvasImage(\"background\", \"../images/back";
_page.AddCanvasImage("background","../images/background.jpg");
 //BA.debugLineNum = 140;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 94;BA.debugLine="theme.AddButtonTheme(\"bluegrey\")";
_theme.AddButtonTheme("bluegrey");
 //BA.debugLineNum = 95;BA.debugLine="theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BL";
_theme.Button("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 96;BA.debugLine="theme.Button(\"bluegrey\").BackColorIntensity = ABM";
_theme.Button("bluegrey").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 99;BA.debugLine="theme.AddContainerTheme(\"modalcontent\")";
_theme.AddContainerTheme("modalcontent");
 //BA.debugLineNum = 100;BA.debugLine="theme.Container(\"modalcontent\").BackColor = ABM.C";
_theme.Container("modalcontent").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 103;BA.debugLine="theme.AddContainerTheme(\"modalfooter\")";
_theme.AddContainerTheme("modalfooter");
 //BA.debugLineNum = 104;BA.debugLine="theme.Container(\"modalfooter\").BackColor = ABM.CO";
_theme.Container("modalfooter").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 107;BA.debugLine="theme.AddToastTheme(\"toastgreen\")";
_theme.AddToastTheme("toastgreen");
 //BA.debugLineNum = 108;BA.debugLine="theme.Toast(\"toastgreen\").Rounded = True";
_theme.Toast("toastgreen").Rounded = __c.True;
 //BA.debugLineNum = 109;BA.debugLine="theme.Toast(\"toastgreen\").BackColor = ABM.COLOR_G";
_theme.Toast("toastgreen").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 110;BA.debugLine="theme.Toast(\"toastgreen\").BackColorIntensity = AB";
_theme.Toast("toastgreen").BackColorIntensity = _abm.INTENSITY_DARKEN2;
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMModalSheet  _buildwronginputmodalsheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodalerror = null;
com.ab.abmaterial.ABMLabel _lbl1 = null;
 //BA.debugLineNum = 395;BA.debugLine="Sub BuildWrongInputModalSheet() As ABMModalSheet";
 //BA.debugLineNum = 396;BA.debugLine="Dim myModalError As ABMModalSheet";
_mymodalerror = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 397;BA.debugLine="myModalError.Initialize(page, \"wronginput\", False";
_mymodalerror.Initialize(_page,"wronginput",__c.False,BA.ObjectToString(__c.False),"");
 //BA.debugLineNum = 398;BA.debugLine="myModalError.Content.UseTheme(\"modalcontent\")";
_mymodalerror.Content.UseTheme("modalcontent");
 //BA.debugLineNum = 399;BA.debugLine="myModalError.Footer.UseTheme(\"modalcontent\")";
_mymodalerror.Footer.UseTheme("modalcontent");
 //BA.debugLineNum = 400;BA.debugLine="myModalError.IsDismissible = True";
_mymodalerror.IsDismissible = __c.True;
 //BA.debugLineNum = 403;BA.debugLine="myModalError.Content.AddRows(1,True, \"\").AddCells";
_mymodalerror.Content.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 404;BA.debugLine="myModalError.Content.BuildGrid 'IMPORTANT once yo";
_mymodalerror.Content.BuildGrid();
 //BA.debugLineNum = 406;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 407;BA.debugLine="lbl1.Initialize(page, \"contlbl1\", \"errormessage\",";
_lbl1.Initialize(_page,"contlbl1","errormessage",_abm.SIZE_PARAGRAPH,__c.False,"");
 //BA.debugLineNum = 408;BA.debugLine="myModalError.Content.Cell(1,1).AddComponent(lbl1)";
_mymodalerror.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl1));
 //BA.debugLineNum = 410;BA.debugLine="Return myModalError";
if (true) return _mymodalerror;
 //BA.debugLineNum = 411;BA.debugLine="End Sub";
return null;
}
public String  _canvas1_canvasdown(int _x,int _y) throws Exception{
 //BA.debugLineNum = 391;BA.debugLine="Sub canvas1_CanvasDown(x As Int, y As Int)";
 //BA.debugLineNum = 392;BA.debugLine="Log(\"X: \" & x & \" y:\" & y)";
__c.Log("X: "+BA.NumberToString(_x)+" y:"+BA.NumberToString(_y));
 //BA.debugLineNum = 393;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private ws As WebSocket 'ignore";
_ws = new anywheresoftware.b4j.object.WebSocket();
 //BA.debugLineNum = 5;BA.debugLine="Public page As ABMPage";
_page = new com.ab.abmaterial.ABMPage();
 //BA.debugLineNum = 7;BA.debugLine="Private theme As ABMTheme";
_theme = new com.ab.abmaterial.ABMTheme();
 //BA.debugLineNum = 9;BA.debugLine="Private ABM As ABMaterial 'ignore";
_abm = new com.ab.abmaterial.ABMaterial();
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"HelperModalSheetPage\"";
_name = "HelperModalSheetPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMButton _btn1 = null;
com.ab.abmaterial.ABMButton _btn2 = null;
com.ab.abmaterial.ABMButton _btn3 = null;
 //BA.debugLineNum = 143;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 145;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 148;BA.debugLine="page.AddModalSheetTemplate(BuildModalSheet)";
_page.AddModalSheetTemplate(_buildmodalsheet());
 //BA.debugLineNum = 151;BA.debugLine="page.AddModalSheetTemplate(BuildWrongInputModalSh";
_page.AddModalSheetTemplate(_buildwronginputmodalsheet());
 //BA.debugLineNum = 154;BA.debugLine="page.AddModalSheetTemplate(BuildFixedFooterSheet)";
_page.AddModalSheetTemplate(_buildfixedfootersheet());
 //BA.debugLineNum = 157;BA.debugLine="page.AddModalSheetTemplate(BuildBottomSheet)";
_page.AddModalSheetTemplate(_buildbottomsheet());
 //BA.debugLineNum = 160;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","An ABMModalSheet component is like a mini ABMPage helper, but it pops up over the existing page.  It has two ABMContainers, one that makes up the header and one for the footer section, so you can use everyting an ABMContainer can.")));
 //BA.debugLineNum = 163;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","ABMModalSheets and itscomponents have to be added to the page in the PageBuild() method. You can the later load the sheet and modify the content before you open it.")));
 //BA.debugLineNum = 179;BA.debugLine="Dim btn1 As ABMButton";
_btn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 180;BA.debugLine="btn1.InitializeRaised(page, \"btn1\", \"\", \"\", \"Open";
_btn1.InitializeRaised(_page,"btn1","","","Open Modal Sheet","bluegrey");
 //BA.debugLineNum = 181;BA.debugLine="page.Cell(2,1).AddComponent(btn1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn1));
 //BA.debugLineNum = 184;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","If you were to hasty and did not enter your name when you pressed ok, you will have noticed two features of the ABMModalSheet with the Error box: cascading modal sheets and dismissable. Modal sheets can indeed come on top of each other. This is usefull for e.g. showing a message to the user when he/she did something wrong.")));
 //BA.debugLineNum = 186;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","Depending on you setting the sheets property {B}IsDismissible{/B} to true or false, a sheet can be dismissed if the user clicks outside the box into the darkened area.")));
 //BA.debugLineNum = 189;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Modals with Fixed Footer")));
 //BA.debugLineNum = 191;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par5","If you have content that is very long and you want the action buttons to be visible all the time, you can set the FixedFooter to true parameter in the Initialize to the modal.")));
 //BA.debugLineNum = 194;BA.debugLine="Dim btn2 As ABMButton";
_btn2 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 195;BA.debugLine="btn2.InitializeRaised(page, \"btn2\", \"\", \"\", \"Open";
_btn2.InitializeRaised(_page,"btn2","","","Open Modal Sheet","bluegrey");
 //BA.debugLineNum = 196;BA.debugLine="page.Cell(5,1).AddComponent(btn2)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn2));
 //BA.debugLineNum = 199;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","Bottom Model Sheets")));
 //BA.debugLineNum = 201;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par6","Bottom Sheet Modals are good for displaying actions to the user on the bottom of a screen. They still act the same as regular modals.")));
 //BA.debugLineNum = 204;BA.debugLine="Dim btn3 As ABMButton";
_btn3 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 205;BA.debugLine="btn3.InitializeRaised(page, \"btn3\", \"\", \"\", \"Open";
_btn3.InitializeRaised(_page,"btn3","","","Open Modal Sheet","bluegrey");
 //BA.debugLineNum = 206;BA.debugLine="page.Cell(7,1).AddComponent(btn3)";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn3));
 //BA.debugLineNum = 211;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 213;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 216;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 218;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 20;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 22;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public String  _msbtn1_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _inp1 = null;
String _yourname = "";
com.ab.abmaterial.ABMModalSheet _mymodalerror = null;
com.ab.abmaterial.ABMLabel _mymodallbl = null;
 //BA.debugLineNum = 458;BA.debugLine="Sub msbtn1_Clicked(Target As String)";
 //BA.debugLineNum = 459;BA.debugLine="Dim mymodal As ABMModalSheet = page.ModalSheet(\"m";
_mymodal = _page.ModalSheet("myModal");
 //BA.debugLineNum = 461;BA.debugLine="Dim inp1 As ABMInput = mymodal.Content.Cell(2,1).";
_inp1 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Cell((int) (2),(int) (1)).Component("inp1"));
 //BA.debugLineNum = 462;BA.debugLine="Dim YourName As String = inp1.Text";
_yourname = _inp1.getText();
 //BA.debugLineNum = 463;BA.debugLine="If YourName = \"\" Then";
if ((_yourname).equals("")) { 
 //BA.debugLineNum = 464;BA.debugLine="Dim mymodalError As ABMModalSheet = page.ModalSh";
_mymodalerror = _page.ModalSheet("wronginput");
 //BA.debugLineNum = 465;BA.debugLine="Dim myModalLbl As ABMLabel= mymodalError.Content";
_mymodallbl = (com.ab.abmaterial.ABMLabel)(_mymodalerror.Content.Component("contlbl1"));
 //BA.debugLineNum = 467;BA.debugLine="myModalLbl.Text = \"Enter at least your first nam";
_mymodallbl.Text = "Enter at least your first name!";
 //BA.debugLineNum = 469;BA.debugLine="page.ShowModalsheet(\"wronginput\")";
_page.ShowModalSheet("wronginput");
 //BA.debugLineNum = 470;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 473;BA.debugLine="page.CloseModalSheet(\"myModal\")";
_page.CloseModalSheet("myModal");
 //BA.debugLineNum = 474;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 475;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastgreen\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastgreen","We will contact you, "+_yourname+"!",(int) (5000));
 //BA.debugLineNum = 476;BA.debugLine="End Sub";
return "";
}
public String  _msbtn2_clicked(String _target) throws Exception{
 //BA.debugLineNum = 478;BA.debugLine="Sub msbtn2_Clicked(Target As String)";
 //BA.debugLineNum = 479;BA.debugLine="page.CloseModalSheet(\"myModal\")";
_page.CloseModalSheet("myModal");
 //BA.debugLineNum = 480;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 481;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","You cancelled the contact form!",(int) (5000));
 //BA.debugLineNum = 482;BA.debugLine="End Sub";
return "";
}
public String  _msbtn3_clicked(String _target) throws Exception{
 //BA.debugLineNum = 613;BA.debugLine="Sub msbtn3_Clicked(Target As String)";
 //BA.debugLineNum = 614;BA.debugLine="page.CloseModalSheet(\"fixedsheet\")";
_page.CloseModalSheet("fixedsheet");
 //BA.debugLineNum = 615;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 222;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 223;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 224;BA.debugLine="If Action = \"ABMModalSheet\" Then Return";
if ((_action).equals("ABMModalSheet")) { 
if (true) return "";};
 //BA.debugLineNum = 225;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 226;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 227;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 228;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 230;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 231;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 232;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 234;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 57;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 58;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 59;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 60;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 61;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 62;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 63;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 65;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 66;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 67;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 68;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 70;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 72;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 74;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 75;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 76;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 78;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 82;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 237;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 238;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 239;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 240;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 241;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 25;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 26;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 27;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 28;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 29;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 31;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 32;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 33;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 34;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 38;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 39;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 41;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 43;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 46;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 48;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 50;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 54;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
