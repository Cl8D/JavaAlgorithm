package Programmers.Level2;

import java.util.*;

// 스킬트리
class SkillTree {
    private static final Map<Character, Character> skillInfo = new HashMap<>();
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        // skill -> 선행 스킬 순서
        // skill_trees -> 유저들이 만든 스킬트리
        for (int i=0; i<skill.length(); i++) {
            if (i == 0) {
                skillInfo.put(skill.charAt(0), null);
                continue;
            }
            skillInfo.put(skill.charAt(i), skill.charAt(i-1));
        }


        for (String skillName : skill_trees) {
            if(checkSkillOrder(skillName)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean checkSkillOrder(String skillName) {
        for (int i=0; i<skillName.length(); i++) {
            Character partSkill = skillName.charAt(i);
            if (!skillInfo.containsKey(partSkill)) {
                continue;
            }

            Character prevSkill = skillInfo.get(partSkill);
            // 가장 첫 스킬의 경우 이전에 스킬 정보에 이전 스킬의 정보가 존재하면 잘못된 순서니까 false.
            if (i == 0) {
                if (prevSkill != null) {
                    return false;
                }
                continue;
            }

            // 첫 스킬이 아니라면 이전의 스킬을 검사한다.
            String subSkill = skillName.substring(0, i);
            if (prevSkill != null && !subSkill.contains(String.valueOf(prevSkill))) {
                return false;
            }
        }
        return true;
    }
}