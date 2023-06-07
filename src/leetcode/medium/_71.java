package leetcode.medium;

import java.util.Stack;

// 71. Simplify Path
class _71 {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for (String p : paths) {
            if (p.equals(".") || p.isEmpty()) {
                continue;
            }
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.add(p);
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < stack.size(); i++) {
            answer.append('/');
            answer.append(stack.elementAt(i));
        }

        if (answer.length() == 0) {
            return "/";
        }
        return answer.toString();
    }
}
