package ca.umanitoba.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC721AccountsMerge {
    private static class UF {
        private final Map<String, String> roots = new HashMap<>();

        private String find(String str) {
            String root = roots.getOrDefault(str, str);
            if (!root.equals(str)) root = find(root);
            roots.put(str, root);
            return root;
        }

        private void union(String a, String b) {
            roots.put(find(a), find(b));
        }
    }

    private final UF uf = new UF();
    private final Map<String, String> owners = new HashMap<>();
    private final Map<String, List<String>> groups = new HashMap<>();
    private final List<List<String>> results = new ArrayList<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            String owner = account.get(0), first = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String cur = account.get(i);
                owners.put(cur, owner);
                uf.union(first, cur);
            }
        }

        for (String key : owners.keySet()) {
            String root = uf.find(key);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(key);
        }

        for (List<String> group : groups.values()) {
            Collections.sort(group);
            String owner = owners.get(group.get(0));
            List<String> result = new ArrayList<>(group.size() + 1);
            result.add(owner);
            result.addAll(group);
            results.add(result);
        }

        return results;
    }
}
