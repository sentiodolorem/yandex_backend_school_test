package solutions;

import java.util.*;

public class B {
    private final static Scanner scanner = new Scanner(System.in);

    public static class Info {
        String name;
        int task;
        int penalty;

        public Info(String name, int task, int penalty) {
            this.name = name;
            this.task = task;
            this.penalty = penalty;
        }
    }

    public static void solve() {
        int n = scanner.nextInt();
        Map<String, Integer> limit = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String vacancy = scanner.next();
            String[] now = vacancy.split(",");
            String title = now[0];
            int count = Integer.parseInt(now[1]);
            limit.put(title, count);
        }
        int m = scanner.nextInt();
        Map<String, ArrayList<Info>> all = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            String candidate = scanner.next();
            String[] now = candidate.split(",");
            String name = now[0];
            String title = now[1];
            int task = Integer.parseInt(now[2]);
            int penalty = 1000000000 - Integer.parseInt(now[3]);
            ArrayList<Info> current = all.getOrDefault(title, new ArrayList<>());
            current.add(new Info(name, task, penalty));
            all.put(title, current);
        }
        ArrayList<String> accepted = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Info>> entry : all.entrySet()) {
            ArrayList<Info> now = entry.getValue();
            now.sort((o1, o2) -> {
                if (o1.task != o2.task) {
                    return o2.task - o1.task;
                }
                if (o1.penalty != o2.penalty) {
                    return o2.penalty - o1.penalty;
                }
                return o2.name.compareTo(o1.name);
            });
            String title = entry.getKey();
            int Limit = Math.min(limit.get(title), now.size());
            while (Limit-- > 0) {
                accepted.add(now.get(Limit).name);
            }
        }
        accepted.sort(Comparator.naturalOrder());
        for (String to : accepted) {
            System.out.println(to);
        }
    }
}
