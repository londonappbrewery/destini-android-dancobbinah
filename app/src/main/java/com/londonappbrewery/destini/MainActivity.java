package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
        private TextView mTextStory;
        private Button mTopButton;
        private Button mBottomButton;

        private int[] mStoryArray;
        private  int[] mAnswerArray_1;
        private  int[]mAnswerArray_2;

        private  int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStoryIndex=1;

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextStory=findViewById(R.id.storyTextView);
        mTopButton=findViewById(R.id.buttonTop);
        mBottomButton=findViewById(R.id.buttonBottom);

        mStoryArray=new int[]{R.string.T1_Story,
                R.string.T2_Story,
                R.string.T3_Story,
                R.string.T4_End,
                R.string.T5_End,
                R.string.T6_End
        };
        mAnswerArray_1=new int[]{R.string.T1_Ans1,R.string.T2_Ans1,R.string.T3_Ans1};
        mAnswerArray_2=new int[]{R.string.T1_Ans2,R.string.T2_Ans2,R.string.T3_Ans2};



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex==1)
                {
                    mStoryIndex=3;
                }else if(mStoryIndex==2)
                {
                    mStoryIndex=3;
                }
                else if(mStoryIndex==3)
                {
                    mStoryIndex=6;
                }

                UpdateStoryView(mStoryIndex);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex==1)
                {
                    mStoryIndex=2;
                }else if(mStoryIndex==2)
                {
                    mStoryIndex=4;
                }else if(mStoryIndex==3)
                {
                    mStoryIndex=5;
                }

                UpdateStoryView(mStoryIndex);
            }
        });



    }
    private void UpdateStoryView(int index)
    {
        index--;
        mTextStory.setText(mStoryArray[index]);
        if(index<3) {
            mTopButton.setText(mAnswerArray_1[index]);
            mBottomButton.setText(mAnswerArray_2[index]);
        }
        else {
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }
    }
}
