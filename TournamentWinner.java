import java.util.*;

public class TournamentWinner {

	public static String tournament(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
		HashMap<String, Integer> scores = new HashMap<>();
		String currentBestTeam = "";
		scores.put(currentBestTeam, 0);

		for (int i = 0; i < competitions.size(); i++) {
			ArrayList<String> teams = competitions.get(i);
			int result = results.get(i);

			String homeTeam = teams.get(0);
			String awayTeam = teams.get(1);

			String winner = (result == 1) ? homeTeam : awayTeam;

			if (!scores.containsKey(winner)) {
				scores.put(winner, 0);
			}

			scores.put(winner, scores.get(winner) + 3);

			if (scores.get(winner) > scores.get(currentBestTeam)) {
				currentBestTeam = winner;
			}
		}
		return currentBestTeam;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> competitions = new ArrayList<>();

		competitions.add((new ArrayList<String>(Arrays.asList(
							"HTML", "C#"))));
		competitions.add((new ArrayList<String>(Arrays.asList(
                            "C#", "Python"))));
		competitions.add((new ArrayList<String>(Arrays.asList(
							"Python", "HTML"))));

		ArrayList<Integer> results = new ArrayList<Integer>(
				Arrays.asList(0, 0, 1));

		System.out.println(tournament(competitions, results));
	}
}
