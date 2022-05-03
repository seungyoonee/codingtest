import java.util.*;

public class Earliest_And_Latest_Access_Time_ver1 {

    public static HashMap<String, ArrayList<Integer>> getAccessTime(String[][] logs) {
        /*
        Example:
        {'user_1': [54001, 58523],
        'user_2': [54060, 62314],
        'user_3': [53760, 53760],
        'user_5': [53651, 53651],
        'user_6': [2, 215],
        'user_7': [400, 400],
        'user_8': [100, 100],
        'user_22': [58522, 58522],
        }
        */
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < logs.length; i++) {
            String user = logs[i][1];
            int minAccess = Integer.parseInt(logs[i][0]);
            int maxAccess = Integer.parseInt(logs[i][0]);

            if (map.containsKey(user)) {
                continue;
            }
            else {
                for (int j = i + 1; j < logs.length; j++) {
                    if (logs[j][1] == user) {
                        minAccess = Math.min(minAccess, Integer.parseInt(logs[j][0]));
                        maxAccess = Math.max(maxAccess, Integer.parseInt(logs[j][0]));
                    }
                }
                map.put(user, new ArrayList<>(Arrays.asList(minAccess, maxAccess)));
            }
        }
        
        return map;
    }

    public static void main(String args[]) {
        //ArrayList<ArrayList<String>> log1 = new ArrayList<ArrayList<String>>();
        String[][] log1 = {
            {"58523", "user_1", "resource_1"},
            {"62314", "user_2", "resource_2"},
            {"54001", "user_1", "resource_3"},
            {"200", "user_6", "resource_5"},
            {"215", "user_6", "resource_4"},
            {"54060", "user_2", "resource_3"},
            {"53760", "user_3", "resource_3"},
            {"58522", "user_22", "resource_1"},
            {"53651", "user_5", "resource_3"},
            {"2", "user_6", "resource_1"},
            {"100", "user_6", "resource_6"},
            {"400", "user_7", "resource_2"},
            {"100", "user_8", "resource_6"},
            {"54359", "user_1", "resource_3"},
            };

        String[][] log2 = {
            {"300", "user_1", "resource_3"},
            {"599", "user_1", "resource_3"},
            {"900", "user_1", "resource_3"},
            {"1199", "user_1", "resource_3"},
            {"1200", "user_1", "resource_3"},
            {"1201", "user_1", "resource_3"},
            {"1202", "user_1", "resource_3"}
        };

        System.out.println(getAccessTime(log1).toString());
    }
}