package edu.memory.game.memorygame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView  tvPlayerOne, tvPlayerTwo, tvPlayerOneScore, tvPlayerTwoScore;

    ImageButton card0, card1, card2, card3, card4, card5, card6, card7, card8, card9,
            card10, card11, card12, card13, card14, card15, card16, card17, card18,card19;

    Integer[] cardsArray = {101,102,103,104,105,106,107,108,109,110,
            201,202,203,204,205,206,207,208,209,210};

    int image101,image102,image103,image104,image105,image106,image107,image108,image109,image110
            ,image201,image202,image203,image204,image205,image206,image207,image208,image209,image210;

    int index;

    String gameMode;
    String gameDifficulty;

    Map<Integer,Integer> cpuMemory = new LinkedHashMap<>();
    private Random randomGenerator = new Random();
    private ArrayList<ImageButton> cards = new ArrayList<ImageButton>();
    private ArrayList<Integer> removedCards = new ArrayList<Integer>();

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;

    int cardCount = 1;
    int turn = 1;

    int playerOnePoints = 0, playerTwoPoints = 0;

    Handler handler = new Handler();

    static boolean active = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();

        gameMode = i.getStringExtra("GameMode");
        gameDifficulty = i.getStringExtra("GameDifficulty");

        tvPlayerOneScore = (TextView) findViewById(R.id.tvPlayerOneScore);
        tvPlayerTwoScore = (TextView) findViewById(R.id.tvPlayerTwoScore);
        tvPlayerOne = (TextView) findViewById(R.id.tvPlayerOne);
        tvPlayerTwo = (TextView) findViewById(R.id.tvPlayerTwo);

        card0 = (ImageButton) findViewById(R.id.card1);
        card1 = (ImageButton) findViewById(R.id.card2);
        card2 = (ImageButton) findViewById(R.id.card3);
        card3 = (ImageButton) findViewById(R.id.card4);
        card4 = (ImageButton) findViewById(R.id.card5);
        card5 = (ImageButton) findViewById(R.id.card6);
        card6 = (ImageButton) findViewById(R.id.card7);
        card7 = (ImageButton) findViewById(R.id.card8);
        card8 = (ImageButton) findViewById(R.id.card9);
        card9 = (ImageButton) findViewById(R.id.card10);
        card10 = (ImageButton) findViewById(R.id.card11);
        card11 = (ImageButton) findViewById(R.id.card12);
        card12 = (ImageButton) findViewById(R.id.card13);
        card13 = (ImageButton) findViewById(R.id.card14);
        card14 = (ImageButton) findViewById(R.id.card15);
        card15 = (ImageButton) findViewById(R.id.card16);
        card16 = (ImageButton) findViewById(R.id.card17);
        card17 = (ImageButton) findViewById(R.id.card18);
        card18 = (ImageButton) findViewById(R.id.card19);
        card19 = (ImageButton) findViewById(R.id.card20);

        cards.add(0,card0);
        cards.add(1,card1);
        cards.add(2,card2);
        cards.add(3,card3);
        cards.add(4,card4);
        cards.add(5,card5);
        cards.add(6,card6);
        cards.add(7,card7);
        cards.add(8,card8);
        cards.add(9,card9);
        cards.add(10,card10);
        cards.add(11,card11);
        cards.add(12,card12);
        cards.add(13,card13);
        cards.add(14,card14);
        cards.add(15,card15);
        cards.add(16,card16);
        cards.add(17,card17);
        cards.add(18,card18);
        cards.add(19,card19);

        card0.setTag("0");
        card1.setTag("1");
        card2.setTag("2");
        card3.setTag("3");
        card4.setTag("4");
        card5.setTag("5");
        card6.setTag("6");
        card7.setTag("7");
        card8.setTag("8");
        card9.setTag("9");
        card10.setTag("10");
        card11.setTag("11");
        card12.setTag("12");
        card13.setTag("13");
        card14.setTag("14");
        card15.setTag("15");
        card16.setTag("16");
        card17.setTag("17");
        card18.setTag("18");
        card19.setTag("19");

        tvPlayerOne.setTextColor(Color.BLACK);
        tvPlayerOneScore.setTextColor(Color.BLACK);
        tvPlayerTwo.setTextColor(Color.GRAY);
        tvPlayerTwoScore.setTextColor(Color.GRAY);

        if(gameMode.equals("cpu")) {
            tvPlayerTwo.setText("CPU");
        } else if(gameMode.equals("1player")) {
            tvPlayerTwo.setText("");
            tvPlayerTwoScore.setText("");
        }

        frontOfCardsResources();

        Collections.shuffle(Arrays.asList(cardsArray));

        card0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card0, theCard);
            }
        });
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card1, theCard);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card2, theCard);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card3, theCard);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card4, theCard);
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card5, theCard);
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card6, theCard);
            }
        });
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card7, theCard);
            }
        });
        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card8, theCard);
            }
        });
        card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card9, theCard);
            }
        });
        card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card10, theCard);
            }
        });
        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card11, theCard);
            }
        });
        card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card12, theCard);
            }
        });
        card13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card13, theCard);
            }
        });
        card14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card14, theCard);
            }
        });
        card15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card15, theCard);
            }
        });
        card16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card16, theCard);
            }
        });
        card17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card17, theCard);
            }
        });
        card18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card18, theCard);
            }
        });
        card19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doAction(card19, theCard);
            }
        });
    }

    private void doAction(ImageButton ib, int card) {
        if(cardsArray[card] == 101) {
            ib.setBackgroundResource(image101);
        } else if (cardsArray[card] == 102) {
            ib.setBackgroundResource(image102);
        } else if (cardsArray[card] == 103) {
            ib.setBackgroundResource(image103);
        } else if (cardsArray[card] == 104) {
            ib.setBackgroundResource(image104);
        } else if (cardsArray[card] == 105) {
            ib.setBackgroundResource(image105);
        } else if (cardsArray[card] == 106) {
            ib.setBackgroundResource(image106);
        } else if (cardsArray[card] == 107) {
            ib.setBackgroundResource(image107);
        } else if (cardsArray[card] == 108) {
            ib.setBackgroundResource(image108);
        } else if (cardsArray[card] == 109) {
            ib.setBackgroundResource(image109);
        } else if (cardsArray[card] == 110) {
            ib.setBackgroundResource(image110);
        } else if (cardsArray[card] == 201) {
            ib.setBackgroundResource(image201);
        } else if (cardsArray[card] == 202) {
            ib.setBackgroundResource(image202);
        } else if (cardsArray[card] == 203) {
            ib.setBackgroundResource(image203);
        } else if (cardsArray[card] == 204) {
            ib.setBackgroundResource(image204);
        } else if (cardsArray[card] == 205) {
            ib.setBackgroundResource(image205);
        } else if (cardsArray[card] == 206) {
            ib.setBackgroundResource(image206);
        } else if (cardsArray[card] == 207) {
            ib.setBackgroundResource(image207);
        } else if (cardsArray[card] == 208) {
            ib.setBackgroundResource(image208);
        } else if (cardsArray[card] == 209) {
            ib.setBackgroundResource(image209);
        } else if (cardsArray[card] == 210) {
            ib.setBackgroundResource(image210);
        }

        if(gameMode.equals("cpu")) {
            cpuMemory.put(card,cardsArray[card]);
        }

        if(cardCount == 1) {
            firstCard = cardsArray[card];
            if(firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardCount = 2;
            clickedFirst = card;

            ib.setEnabled(false);
        } else if(cardCount == 2) {
            secondCard = cardsArray[card];
            if(secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardCount = 1;
            clickedSecond = card;

            for (ImageButton a: cards) {
                a.setEnabled(false);
            }


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            },1000);
        }
    }

    private void calculate() {
        if(firstCard == secondCard) {

            cards.get(clickedFirst).setVisibility(View.INVISIBLE);
            cards.get(clickedSecond).setVisibility(View.INVISIBLE);

            if(turn == 1) {
                playerOnePoints++;
                tvPlayerOneScore.setText(playerOnePoints+"");
            } else if (turn == 2) {
                playerTwoPoints++;
                tvPlayerTwoScore.setText(playerTwoPoints+"");

                if(gameMode.equals("cpu")) {
                    cpuPlay();
                }
            }

            removedCards.add(clickedFirst);
            removedCards.add(clickedSecond);

            if (gameMode.equals("cpu")) {
                cpuMemory.remove(clickedFirst);
                cpuMemory.remove(clickedSecond);
            }

        } else {
            for (ImageButton a: cards) {
                a.setBackgroundResource(R.drawable.ic_unknown);
            }

            if(turn == 1) {
                turn = 2;
                tvPlayerOne.setTextColor(Color.GRAY);
                tvPlayerOneScore.setTextColor(Color.GRAY);
                tvPlayerTwo.setTextColor(Color.BLACK);
                tvPlayerTwoScore.setTextColor(Color.BLACK);

                if(gameMode.equals("cpu")) {
                    cpuPlay();
                }
            } else if(turn == 2) {
                turn = 1;
                tvPlayerOne.setTextColor(Color.BLACK);
                tvPlayerOneScore.setTextColor(Color.BLACK);
                tvPlayerTwo.setTextColor(Color.GRAY);
                tvPlayerTwoScore.setTextColor(Color.GRAY);
            }

            if( gameMode.equals("1player") ) {
                turn = 1;
                tvPlayerOne.setTextColor(Color.BLACK);
                tvPlayerOneScore.setTextColor(Color.BLACK);
            }
        }

        for (ImageButton a: cards) {
            a.setEnabled(true);
        }

        checkEnd();
    }

    private void cpuPlay() {

        if(gameDifficulty.equals("easy")) {
            Iterator<Map.Entry<Integer,Integer>> iterator = cpuMemory.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer,Integer> entry = iterator.next();
                if(cpuMemory.size() > 2){
                    iterator.remove();
                }
            }
        } else if(gameDifficulty.equals("medium")) {
            Iterator<Map.Entry<Integer,Integer>> iterator = cpuMemory.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer,Integer> entry = iterator.next();
                if(cpuMemory.size() > 4){
                    iterator.remove();
                }
            }
        }

        for (ImageButton a: cards) {
            a.setClickable(false);
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean match = false;

                if (removedCards.size() != cards.size()) {

                    for (int key1 : cpuMemory.keySet()) {
                        for (int key2 : cpuMemory.keySet()) {
                            if (Math.abs(cpuMemory.get(key1) - (cpuMemory.get(key2))) == 100) {
                                index = key1;
                                match = true;
                                break;
                            }
                        }
                    }

                    if(removedCards.size() == 16 && gameDifficulty.equals("hard")) {
                        while (removedCards.contains(index) || cpuMemory.containsKey(index)) {
                            randomGenerator = new Random();
                            index = randomGenerator.nextInt(cards.size());
                        }
                        match = true;
                    }

                    if (!match) {
                        index = randomGenerator.nextInt(cards.size());

                        while (removedCards.contains(index)) {
                            randomGenerator = new Random();
                            index = randomGenerator.nextInt(cards.size());
                        }
                    }

                    ImageButton ib = cards.get(index);
                    doAction(ib, index);
                }
            }
        },1000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean match = false;
                int tempIndex = index;

                if (removedCards.size() != cards.size()) {

                    for (int key1 : cpuMemory.keySet()) {
                        for (int key2 : cpuMemory.keySet()) {
                            if (Math.abs(cpuMemory.get(key1) - (cpuMemory.get(key2))) == 100) {
                                if (tempIndex != key2) {
                                    index = key2;
                                    match = true;
                                    break;
                                }
                            }
                        }
                    }

                    if (!match) {
                        while (index == tempIndex || removedCards.contains(index) || cpuMemory.containsKey(index)) {
                            randomGenerator = new Random();
                            index = randomGenerator.nextInt(cards.size());
                        }
                    }
                    if(!match)
                    {
                        while ((index ==tempIndex || removedCards.contains(index) || cpuMemory.containsKey(index)))
                        {
                            randomGenerator = new Random();
                            index = randomGenerator.nextInt(cards.size());
                        }
                    }

                    ImageButton ib = cards.get(index);
                    doAction(ib, index);

                    for (ImageButton a : cards) {
                        a.setClickable(true);
                    }
                }
            }
        },2000);
    }

    private void checkEnd() {

        if(cards.size() == removedCards.size()){
            if(active) {
                Intent intent = new Intent(getApplicationContext(),Result.class);
                intent.putExtra("playerOnePoints",playerOnePoints);
                intent.putExtra("playerTwoPoints",playerTwoPoints);
                intent.putExtra("PlayerTwo",tvPlayerTwo.getText());
                intent.putExtra("GameMode",gameMode);
                intent.putExtra("GameDifficulty",gameDifficulty);
                startActivity(intent);
                finish();
            }
        }
    }

    private void frontOfCardsResources() {
        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image104 = R.drawable.ic_image104;
        image105 = R.drawable.ic_image105;
        image106 = R.drawable.ic_image106;
        image107 = R.drawable.ic_image107;
        image108 = R.drawable.ic_image108;
        image109 = R.drawable.ic_image109;
        image110 = R.drawable.ic_image110;
        image201 = R.drawable.ic_image101;
        image202 = R.drawable.ic_image102;
        image203 = R.drawable.ic_image103;
        image204 = R.drawable.ic_image104;
        image205 = R.drawable.ic_image105;
        image206 = R.drawable.ic_image106;
        image207 = R.drawable.ic_image107;
        image208 = R.drawable.ic_image108;
        image209 = R.drawable.ic_image109;
        image210 = R.drawable.ic_image110;
    }
    @Override
    public void onBackPressed()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        active = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        active = false;
    }
}
