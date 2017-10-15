package com.example.akhildixit.purble_place;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifTextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;


    GridView gridView;
    Animation animation;
    Integer first=1,second=2;
    int marks=0;
    int i=0;
    TextView score;
    ImageView img2;
    Boolean bool=true;
   ArrayList<Integer> foundid=new ArrayList<>();
    GifTextView gifTextView;

  Integer imageIDs[]={R.drawable.clock,R.drawable.instagram,R.drawable.panda,R.drawable.star,
          R.drawable.youtube,R.drawable.setting,R.drawable.bird,R.drawable.human,R.drawable.whatsapp,
          R.drawable.earth,R.drawable.clock,R.drawable.instagram,R.drawable.panda,R.drawable.star,
          R.drawable.youtube,R.drawable.setting,R.drawable.bird,R.drawable.human,R.drawable.whatsapp,
          R.drawable.earth};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialisation();

        gridView.setAdapter(new ImageAdapterGridView(this));

        SettingGridView_Features();


    }

    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        ImageView mImageView;
        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {


            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(250, 250));/*This is to increase the height and width of each use
                this to scale images etc*/
                mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            } else {
                mImageView = (ImageView) convertView;
            }

            mImageView.setImageResource(R.drawable.leaf);
            return mImageView;
        }
    }
    @Override
    public void onStop()/*To stop the audio when app stops*/
    {
        super.onStop();
        mediaPlayer.stop();


    }

    public void initialisation()/*To initialise variables*/
    {

        gifTextView=(GifTextView)findViewById(R.id.congratultions);
        gifTextView.setVisibility(View.INVISIBLE);

        mediaPlayer=new MediaPlayer();

        mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.background);

        mediaPlayer.start();
        mediaPlayer.setLooping(true);



        gridView=(GridView)findViewById(R.id.gridview);
        score=(TextView)findViewById(R.id.score);
    }

    public void SettingGridView_Features()
    {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, final int position, long id) {
                final ImageView imageView = (ImageView) v;
                final Handler handler = new Handler();

                if (!foundid.contains(imageIDs[position])) {
                    imageView.setImageResource(imageIDs[position]);

                    if (first != second) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {


                                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.flip);


                                imageView.startAnimation(animation);
                                imageView.setImageResource(R.drawable.leaf);

                            }

                        };
                        handler.postDelayed(runnable, 1500);}

                }



                if (i == 0) {
                    first = imageIDs[position];

                    i++;
                    img2 = (ImageView) v;


                } else if (i == 1) {
                    second = imageIDs[position];
                    if ((first.equals(second)) && (!(foundid.contains(imageIDs[position])))) {
                        marks++;

                        Runnable run2=new Runnable() {
                            @Override
                            public void run() {
                                img2.setImageResource(imageIDs[position]);

                            }
                        };
                        handler.postDelayed(run2,800);


                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageResource(R.drawable.done);
                                img2.setImageResource(R.drawable.done);
                                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.flip);


                                imageView.startAnimation(animation);
                                img2.startAnimation(animation);
                                score.setText("SCORE-:"+marks);


                            }
                        };
                        handler.postDelayed(runnable, 1500);
                        Runnable run3=new Runnable() {
                            @Override
                            public void run() {

                                gifTextView.setVisibility(View.VISIBLE);

                            }
                        };
                        handler.postDelayed(run3,2000);
                        /*Can we do it in single time means can't we do it in single runnabe*/

                        Runnable run4=new Runnable() {
                            @Override
                            public void run() {
                                animation=AnimationUtils.loadAnimation(MainActivity.this,R.anim.blink);
                                gifTextView.startAnimation(animation);
                                gifTextView.setVisibility(View.INVISIBLE);

                            }
                        };
                        handler.postDelayed(run4,3100);



                        foundid.add(imageIDs[position]);
                    }
                    i = 0;
                }
            }


        });
    }
    }



