import java.util.*;

public class StableMatching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int n = scanner.nextInt();
        String[] boys = new String[n];
        String[] girls = new String[n];

        for (int i = 0; i < n; i++) {
            boys[i] = scanner.next();
        }

        for (int i = 0; i < n; i++) {
            girls[i] = scanner.next();
        }

        // 创建男孩的偏好映射
        Map<String, List<String>> boyPreferences = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String boyName = boys[i];
            List<String> preferences = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                preferences.add(scanner.next());
            }
            boyPreferences.put(boyName, preferences);
        }

        // 创建女孩的偏好映射
        Map<String, List<String>> girlPreferences = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String girlName = girls[i];
            List<String> preferences = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                preferences.add(scanner.next());
            }
            girlPreferences.put(girlName, preferences);
        }

        // 进行稳定匹配（使用带权值的Gale-Shapley算法）
        Map<String, String> matches = stableMarriageWithWeights(boyPreferences, girlPreferences);

        // 输出稳定匹配结果
        for (String boy : boys) {
            String girl = matches.get(boy);
            System.out.println(boy + " " + girl);
        }

        scanner.close();
    }

    private static Map<String, String> stableMarriageWithWeights(
            Map<String, List<String>> boyPreferences,
            Map<String, List<String>> girlPreferences) {

        Map<String, String> matches = new HashMap<>();
        Queue<String> freeBoys = new LinkedList<>(boyPreferences.keySet());
        Map<String, Integer> nextGirlIndex = new HashMap<>();
        Map<String, Map<String, Integer>> girlWeights = new HashMap<>(); // 存储女孩对男孩的权值

        while (!freeBoys.isEmpty()) {
            String boy = freeBoys.poll();
            List<String> preferences = boyPreferences.get(boy);
            int currentIndex = nextGirlIndex.getOrDefault(boy, 0);

            for (int i = currentIndex; i < preferences.size(); i++) {
                String girl = preferences.get(i);

                if (!matches.containsKey(girl)) {
                    matches.put(boy, girl);
                    nextGirlIndex.put(boy, i + 1);
                    // 初始化女孩对男孩的权值
                    Map<String, Integer> weights = new HashMap<>();
                    weights.put(boy, i);
                    girlWeights.put(girl, weights);
                    break;
                } else {
                    String currentBoy = matches.get(girl);

                    if (isBetterChoice(girl, boy, currentBoy, boyPreferences, girlWeights)) {
                        matches.put(boy, girl);
                        freeBoys.add(currentBoy);
                        nextGirlIndex.put(boy, i + 1);
                        // 更新女孩对男孩的权值
                        Map<String, Integer> weights = girlWeights.get(girl);
                        weights.put(boy, i);
                        break;
                    }
                }
            }
        }

        return matches;
    }

    private static boolean isBetterChoice(
            String girl,
            String newBoy,
            String currentBoy,
            Map<String, List<String>> boyPreferences,
            Map<String, Map<String, Integer>> girlWeights) {

        List<String> preferences = boyPreferences.get(girl);
        Map<String, Integer> weights = girlWeights.get(girl);

        if (weights == null) {
            return true; // 如果权值为null，说明是新匹配，直接接受
        }

        int currentBoyWeight = weights.getOrDefault(currentBoy, Integer.MAX_VALUE);
        int newBoyWeight = weights.getOrDefault(newBoy, Integer.MAX_VALUE);

        return newBoyWeight < currentBoyWeight;
    }
}
