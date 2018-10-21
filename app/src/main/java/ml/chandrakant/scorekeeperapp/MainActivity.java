package ml.chandrakant.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView teamAScore;
    private TextView teamBScore;

    int teamAPoints;
    int teamBPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAScore = findViewById(R.id.team_a_score);
        teamBScore = findViewById(R.id.team_b_score);

        Button touchPointTeamA = findViewById(R.id.team_a_touch_point);
        Button touchPointTeamB = findViewById(R.id.team_b_touch_point);
        Button tackleTeamA = findViewById(R.id.team_a_tackle);
        Button tackleTeamB = findViewById(R.id.team_b_tackle);
        Button allOutTeamA = findViewById(R.id.team_a_all_out);
        Button allOutTeamB = findViewById(R.id.team_b_all_out);
        Button reset = findViewById(R.id.reset);

        /* Scoring Rules (Regional System)
            Touch Point +1
            All out +2
            Tackled -1
         */

        touchPointTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAPoints++;
                updateTeamAScore(teamAPoints);
            }
        });

        touchPointTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBPoints++;
                updateTeamBScore(teamBPoints);
            }
        });

        tackleTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAPoints--;
                updateTeamAScore(teamAPoints);
            }
        });

        tackleTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBPoints--;
                updateTeamBScore(teamBPoints);
            }
        });

        allOutTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAPoints += 2;
                updateTeamAScore(teamAPoints);
            }
        });

        allOutTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBPoints += 2;
                updateTeamBScore(teamBPoints);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                announceResult();
                resetScore();
            }
        });
    }

    private void announceResult() {
        if (teamAPoints > teamBPoints) {
            Toast.makeText(MainActivity.this, "Team A wins!!!", Toast.LENGTH_SHORT).show();
        } else if (teamAPoints < teamBPoints) {
            Toast.makeText(MainActivity.this, "Team B wins!!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Draw!!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetScore() {
        teamAPoints = 0;
        teamBPoints = 0;
        updateTeamAScore(teamAPoints);
        updateTeamBScore(teamBPoints);
    }

    private void updateTeamAScore(int teamAPoints) {
        teamAScore.setText(teamAPoints + "");
    }

    private void updateTeamBScore(int teamBPoints) {
        teamBScore.setText(teamBPoints + "");
    }
}
