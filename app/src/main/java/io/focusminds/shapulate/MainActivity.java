package io.focusminds.shapulate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    HashMap<Integer, String> questionsMap;
    String ansShapeArr[] = new String[15];
    List<Integer> randomizeQnNoList;
    int limit = 15, questionNo = 0, randomQuesNo =0, currentScore = 5;
    ImageView ansImgClick1, ansImgClick2, ansImgClick3, ansImgClick4, ansSymbolImg, exitButton;
    ImageView star1, star2, star3, star4, star5, star6, star7, star8, star9, star10, star11, star12, star13, star14, star15;
    TextView questionTxt, scoreTxt, finalScoreTxt, finalCloseBtn, finalMsgTxt, endScoreTxt, endCloseTxt, endMsgTxt;
    Random rand;
    List<String> answerString;
    List<Integer> ansBtnList;
    MediaPlayer btnClkSnd, wrngSnd, crctSnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionsMap = new HashMap<Integer, String>();
//        gameMode = getIntent().getExtras().getString("mode");
        randomizeQnNoList = new ArrayList<Integer>();
        ansImgClick1 = findViewById(R.id.ansImg1);
        ansImgClick2 = findViewById(R.id.ansImg2);
        ansImgClick3 = findViewById(R.id.ansImg3);
        ansImgClick4 = findViewById(R.id.ansImg4);
        ansSymbolImg = findViewById(R.id.ans_symbol_img);
        exitButton = findViewById(R.id.exit_btn_img);
        rand = new Random();
        ansBtnList = new ArrayList<Integer>(4);
        answerString = new ArrayList<String>(4);
        questionTxt = findViewById(R.id.questions_text);
        scoreTxt = findViewById(R.id.score_text);
        exitButton = findViewById(R.id.exit_btn_img);
        btnClkSnd = MediaPlayer.create(this, R.raw.btn_click_snd);


        {
            star1 = findViewById(R.id.star_0);
            star2 = findViewById(R.id.star_1);
            star3 = findViewById(R.id.star_2);
            star4 = findViewById(R.id.star_3);
            star5 = findViewById(R.id.star_4);
            star6 = findViewById(R.id.star_5);
            star7 = findViewById(R.id.star_6);
            star8 = findViewById(R.id.star_7);
            star9 = findViewById(R.id.star_8);
            star10 = findViewById(R.id.star_9);
            star11 = findViewById(R.id.star_10);
            star12 = findViewById(R.id.star_11);
            star13= findViewById(R.id.star_12);
            star14 = findViewById(R.id.star_13);
            star15 = findViewById(R.id.star_14);

        }

        for (int i = 0; i< limit; i++) {
            randomizeQnNoList.add(i);
        }

        {
            questionsMap.put(0, "Identify the Circle");
            questionsMap.put(1, "Which one looks like a Cone");
            questionsMap.put(2, "Where is the Cube");
            questionsMap.put(3, "Find the Cuboid");
            questionsMap.put(4, "Pick the Cylinder");
            questionsMap.put(5, "There is a Hexagon below select it");
            questionsMap.put(6, "Select the Octagon");
            questionsMap.put(7, "Can you see a Pentagon");
            questionsMap.put(8, "There is a Pyramid Cube in the pictures");
            questionsMap.put(9, "Where is Rectangle");
            questionsMap.put(10, "Click on the Rhombus");
            questionsMap.put(11, "Select the Sphere");
            questionsMap.put(12, "Find the Square");
            questionsMap.put(13, "Which one looks like a Triangle");
            questionsMap.put(14, "Identify the Triangular Pyramid");

            ansShapeArr[0] = "Circle  ";
            ansShapeArr[1] = "Cone  ";
            ansShapeArr[2] = "Cube  ";
            ansShapeArr[3] = "Cuboid  ";
            ansShapeArr[4] = "Cylinder  ";
            ansShapeArr[5] = "Hexagon  ";
            ansShapeArr[6] = "Octagon  ";
            ansShapeArr[7] = "Pentagon   ";
            ansShapeArr[8] = "Pyramid Cube  ";
            ansShapeArr[9] = "Rectangle   ";
            ansShapeArr[10] = "Rhombus  ";
            ansShapeArr[11] = "Sphere  ";
            ansShapeArr[12] = "Square  ";
            ansShapeArr[13] = "Triangle  ";
            ansShapeArr[14] = "Triangular Pyramid  ";
        }

        Collections.shuffle(randomizeQnNoList);
        randomQuesNo = randomizeQnNoList.get(questionNo++);
        quesAnsGeneration(randomQuesNo);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClkSnd.start();
                endPopupCreation("You are Leaving :-(");
            }
        });

        ansImgClick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClkSnd.start();
                if(ansShapeArr[randomQuesNo].equals(answerString.get(0))){
                    crctAnsPopup(ansShapeArr[randomQuesNo]);
                }
                else{
                    wrongAnswerSelection(--currentScore);
                }
            }
        });

        ansImgClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClkSnd.start();
                if(ansShapeArr[randomQuesNo].equals(answerString.get(1))){
                    crctAnsPopup(ansShapeArr[randomQuesNo]);
                }
                else{
                    wrongAnswerSelection(--currentScore);
                }
            }
        });

        ansImgClick3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClkSnd.start();
                if(ansShapeArr[randomQuesNo].equals(answerString.get(2))){
                    crctAnsPopup(ansShapeArr[randomQuesNo]);
                }
                else{
                    wrongAnswerSelection(--currentScore);
                }
            }
        });

        ansImgClick4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClkSnd.start();
                if(ansShapeArr[randomQuesNo].equals(answerString.get(3))){
                    crctAnsPopup(ansShapeArr[randomQuesNo]);
                }
                else{
                    wrongAnswerSelection(--currentScore);
                }
            }
        });
    }


//    ************************************Generating Question Answer********************************************
    public void quesAnsGeneration(int quesNo){
        TypedArray images;
        images = getResources().obtainTypedArray(R.array.images);
        ansSymbolImg.setVisibility(View.INVISIBLE);
        ansBtnList.clear();
        int index =0;
        answerString.clear();
        randomQuesNo = quesNo;
        questionTxt.setText(questionsMap.get(quesNo));
        ansBtnList.add(quesNo);
        while(index < 3)
        {
            int randomNum = rand.nextInt(14);
            if(!(ansBtnList.contains(randomNum))) {
                ansBtnList.add(randomNum);
                index++;
            }
        }
        Collections.shuffle(ansBtnList);
        for(int number : ansBtnList)
            answerString.add(ansShapeArr[number]);

        ansImgClick1.setImageResource(images.getResourceId(Math.abs((ansBtnList.get(0)+1)*3 - rand.nextInt(3)-1) , R.drawable.ic_launcher_foreground));
        ansImgClick2.setImageResource(images.getResourceId(Math.abs((ansBtnList.get(1)+1)*3 - rand.nextInt(3) -1), R.drawable.ic_launcher_foreground));
        ansImgClick3.setImageResource(images.getResourceId(Math.abs((ansBtnList.get(2)+1)*3 - rand.nextInt(3) -1), R.drawable.ic_launcher_foreground));
        ansImgClick4.setImageResource(images.getResourceId(Math.abs((ansBtnList.get(3)+1)*3 - rand.nextInt(3) -1), R.drawable.ic_launcher_foreground));
        images.recycle();
    }

//  **************popup to check whether game completed or not****************
    public void finishPopCreation(int score, String message){

        final Dialog finishDialog = new Dialog(MainActivity.this);
        finishDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        finishDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        finishDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
//                Intent intent = new Intent();
//                intent.putExtra("returnValue", "returned");
//                setResult(RESULT_OK, intent);
                finish();
            }
        });
        finishDialog.setContentView(R.layout.activity_finish_popup);
        finalScoreTxt = finishDialog.findViewById(R.id.final_score_txt);
        finalCloseBtn = finishDialog.findViewById(R.id.final_close_btn);
        finalMsgTxt = finishDialog.findViewById(R.id.message_txt);
        finalMsgTxt.setText(message);
        finalScoreTxt.setText(scoreTxt.getText());
        finalCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishDialog.dismiss();
            }
        });
        finishDialog.show();
    }


//    **************end game on exit btn or game over*****************
    public void endPopupCreation(String message){
        final Dialog endDialog = new Dialog(MainActivity.this);
        endDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        endDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        endDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
//                Intent intent = new Intent();
//                intent.putExtra("returnValue", "returned");
//                setResult(RESULT_OK, intent);
                finish();
            }
        });
        endDialog.setContentView(R.layout.activity_end_popup);
        endScoreTxt = endDialog.findViewById(R.id.end_score_txt);
        endMsgTxt = endDialog.findViewById(R.id.end_message_txt);
        endCloseTxt = endDialog.findViewById(R.id.end_close_btn);

        endScoreTxt.setText(scoreTxt.getText());
        endMsgTxt.setText(message);
        endCloseTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endDialog.dismiss();
            }
        });
        endDialog.show();
    }


//    ********************popup to display shape if answer is correct*********************
    public void crctAnsPopup(String selectedShape){
        crctSnd = MediaPlayer.create(this, R.raw.crct_ans_snd);
        ansSymbolImg.setImageResource(R.drawable.right_ans);
        ansSymbolImg.setVisibility(View.VISIBLE);
        scoreTxt.setText(""+(++currentScore));
        starScore(currentScore, "show");

        final Dialog shapePopup = new Dialog(MainActivity.this);
        shapePopup.requestWindowFeature(Window.FEATURE_NO_TITLE);
        shapePopup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        shapePopup.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                crctSnd.reset();
                if(Integer.parseInt(scoreTxt.getText().toString()) == 15){
                    finishPopCreation(Integer.parseInt(scoreTxt.getText().toString()), "You Cleared the Round");
                }else{
                    if(questionNo == limit-1)
                        finishPopCreation(Integer.parseInt(scoreTxt.getText().toString()), "You Completed all questions");
                    else
                        quesAnsGeneration(randomizeQnNoList.get(questionNo++));

                }
            }
        });
        shapePopup.setContentView(R.layout.activity_crct_ans_popup);
        TextView displayTxt = shapePopup.findViewById(R.id.result_view_txt);
        displayTxt.setTextColor(Color.WHITE);
        displayTxt.setTextSize(25);
        displayTxt.setText("Yaayy!! It is "+ selectedShape.toUpperCase());
        displayTxt.setTypeface(null, Typeface.BOLD);
        shapePopup.show();
        crctSnd.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                shapePopup.dismiss();
            }
        }, 3000);


    }

    //    ************************Wrong answer selection************************
    public void wrongAnswerSelection (int scoreNow){
        wrngSnd = MediaPlayer.create(this, R.raw.wrong_ans_snd);
        wrngSnd.start();
        scoreTxt.setText(""+(scoreNow));
        starScore(currentScore+1, "hide");
        ansSymbolImg.setImageResource(R.drawable.wrong_ans);
        ansSymbolImg.setVisibility(View.VISIBLE);
        if(currentScore == 0){
            endPopupCreation("You are Out");
        }

        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            public void run() {
                ansSymbolImg.setVisibility(View.INVISIBLE);
                wrngSnd.reset();
            }
        }, 1000);

    }


    public void starScore(int currenttScoreStar, String visibility){
        if(visibility.equalsIgnoreCase("show")){
            switch (currenttScoreStar){
                case 1 :
                    star1.setVisibility(View.VISIBLE);
                    break;
                case 2 :
                    star2.setVisibility(View.VISIBLE);
                    break;
                case 3 :
                    star3.setVisibility(View.VISIBLE);
                    break;
                case 4 :
                    star4.setVisibility(View.VISIBLE);
                    break;
                case 5 :
                    star5.setVisibility(View.VISIBLE);
                    break;
                case 6 :
                    star6.setVisibility(View.VISIBLE);
                    break;
                case 7 :
                    star7.setVisibility(View.VISIBLE);
                    break;
                case 8 :
                    star8.setVisibility(View.VISIBLE);
                    break;
                case 9 :
                    star9.setVisibility(View.VISIBLE);
                    break;
                case 10 :
                    star10.setVisibility(View.VISIBLE);
                    break;
                case 11 :
                    star11.setVisibility(View.VISIBLE);
                    break;
                case 12 :
                    star12.setVisibility(View.VISIBLE);
                    break;
                case 13 :
                    star13.setVisibility(View.VISIBLE);
                    break;
                case 14 :
                    star14.setVisibility(View.VISIBLE);
                    break;
                case 15 :
                    star15.setVisibility(View.VISIBLE);
                    break;

            }
        }else if(visibility.equalsIgnoreCase("hide")){
            switch (currenttScoreStar){
                case 1 :
                    star1.setVisibility(View.INVISIBLE);
                    break;
                case 2 :
                    star2.setVisibility(View.INVISIBLE);
                    break;
                case 3 :
                    star3.setVisibility(View.INVISIBLE);
                    break;
                case 4 :
                    star4.setVisibility(View.INVISIBLE);
                    break;
                case 5 :
                    star5.setVisibility(View.INVISIBLE);
                    break;
                case 6 :
                    star6.setVisibility(View.INVISIBLE);
                    break;
                case 7 :
                    star7.setVisibility(View.INVISIBLE);
                    break;
                case 8 :
                    star8.setVisibility(View.INVISIBLE);
                    break;
                case 9 :
                    star9.setVisibility(View.INVISIBLE);
                    break;
                case 10 :
                    star10.setVisibility(View.INVISIBLE);
                    break;
                case 11 :
                    star11.setVisibility(View.INVISIBLE);
                    break;
                case 12 :
                    star12.setVisibility(View.INVISIBLE);
                    break;
                case 13 :
                    star13.setVisibility(View.INVISIBLE);
                    break;
                case 14 :
                    star14.setVisibility(View.INVISIBLE);
                    break;
                case 15 :
                    star15.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    }
    @Override
    protected void onPause(){
        crctSnd.pause();
        wrngSnd.pause();
        super.onPause();
    }

    @Override
    protected void onStop(){
        crctSnd.reset();
        wrngSnd.reset();
        super.onStop();
    }

    @Override
    protected void onResume(){
        crctSnd = MediaPlayer.create(this, R.raw.crct_ans_snd);
        wrngSnd = MediaPlayer.create(this, R.raw.wrong_ans_snd);
        super.onResume();
    }
}