import davidlong_ict167_week7_lab.Score;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class client {
	public static void main(String[] args) {
		
		// get keyboard input
		Scanner keyboard_input = new Scanner(System.in);
		System.out.println("Enter input file name: ");
		String file_name = keyboard_input.nextLine().trim();
		
		// get file input
		Scanner file_input = null;
		try {
			file_input = new Scanner(new File(file_name));
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: Could not open file " + file_name + ".");
			System.out.println("Exiting program.");
			System.exit(0);
		}
		
		// score storage
		Score[] scores = new Score[10];
		
		// retrieve scores from file		
		int line = 0; // also used as number of retrieved records
		while (file_input.hasNextLine()) {
			if (line+1 > 10) break;
			String[] cur_line_data = file_input.nextLine().trim().split(" ");
			scores[line] = new Score(
				cur_line_data[0],
				Integer.parseInt(cur_line_data[1])
			); 
			line++;
		}
		System.out.printf("Retrieved scores from %s\n", file_name);
		//DisplayScores(scores);
		
		// get output file
		String output_file_name = "output.csv";
		PrintWriter output_file_stream = null;
		try {
			output_file_stream = new PrintWriter(output_file_name);
		} catch (FileNotFoundException e) {
			System.out.println("Error: Could not open file " + output_file_name + ".");
			System.out.println("Exiting program.");
			System.exit(0);
		}
		
		// write to output file
		output_file_stream.printf("%d,%.2f,%d,%d\n", 
			line, 
			MeanScore(scores),
			scores[LowestScoreIndex(scores)].GetScore(),
			scores[HighestScoreIndex(scores)].GetScore()
		);
		
		for (int i = 0; i < line; i++) {
			output_file_stream.printf("%s,%d\n", scores[i].GetName(), scores[i].GetScore());
		}
		
		output_file_stream.close();
		
		System.out.println("Outputted scores to output.csv");
		System.out.println("Finished.");
	}
	
	public static void DisplayScores(Score[] scores) {
		int l = scores.length;
		for (int i = 0; i < l; i++) {
			if (scores[i] == null) {
				System.out.printf("%d: null\n", i);
				continue;
			}
			System.out.printf("%2d: %8s-%d\n", i, scores[i].GetName(), scores[i].GetScore());
		}
	}
	
	public static float MeanScore(Score[] scores) {
		int sum = 0;
		int l = scores.length;
		for (int j = 0; j < l; j++) {
			if (scores[j] == null) continue;
			sum += scores[j].GetScore();
		}
		return (float)sum/(float)l;
	}
	
	public static int LowestScoreIndex(Score[] scores) {
		int ret = 0;
		int l = scores.length;
		int min = 9999;
		for (int j = 0; j < l; j++) {
			if (scores[j] == null) continue;
			if (scores[j].GetScore() < min) {
				min = scores[j].GetScore();
				ret = j;
			}
		}
		return ret;
	}
	
	public static int HighestScoreIndex(Score[] scores) {
		int ret = 0;
		int l = scores.length;
		int max = -9999;
		for (int j = 0; j < l; j++) {
			if (scores[j] == null) continue;
			if (scores[j].GetScore() > max) {
				max = scores[j].GetScore();
				ret = j;
			}
		}
		return ret;
	}
}
