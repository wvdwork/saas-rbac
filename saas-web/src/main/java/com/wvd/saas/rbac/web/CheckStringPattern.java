package com.wvd.saas.rbac.web;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckStringPattern {

    class CheckVo {
        private String value;
        private String pattern;
        private List<Integer> valuePoints = new ArrayList();
        private List<String> patternPoints = new ArrayList();

        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public List<Integer> getValuePoints() {
            return valuePoints;
        }

        public void setValuePoints(List<Integer> valuePoints) {
            this.valuePoints = valuePoints;
        }

        public List<String> getPatternPoints() {
            return patternPoints;
        }

        public void setPatternPoints(List<String> patternPoints) {
            this.patternPoints = patternPoints;
        }
    }

    public boolean checkStringWithPattern(String checkStr, String pattern) {
        if (checkStr == null || checkStr.length() == 0 || pattern == null || pattern.length() == 0) {
            return false;
        }
        String[] values = checkStr.split(" ");
        if (values.length != pattern.length()) {
            return false;
        }

        Map<String, CheckVo> checkVosMap = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            CheckVo checkVo = null;
            if (checkVosMap.get(values[i]) != null) {
                checkVo = checkVosMap.get(values[i]);
            } else {
                for (CheckVo checkVo1 : checkVosMap.values()) {
                    if (checkVo1.getPattern().equals(String.valueOf(pattern.charAt(i)))) {
                        return false;
                    }
                }
                checkVo = new CheckVo();
                checkVo.setValue(values[i]);
                checkVo.setPattern(String.valueOf(pattern.charAt(i)));
                checkVosMap.put(values[i], checkVo);
            }

            if (String.valueOf(pattern.charAt(i)).equals(checkVo.getPattern())) {
                checkVo.getPatternPoints().add(String.valueOf(pattern.charAt(i)));
            }

        }

        int i = 0;
        for (CheckVo vo: checkVosMap.values()) {
            if (CollectionUtils.isNotEmpty(vo.getPatternPoints())) {
                if(vo.getPattern() == null ) {
                    return false;
                }
                String fist = vo.getPatternPoints().get(0);
                for (String str: vo.getPatternPoints()) {
                    if (!fist.equals(str)) {
                        return false;
                    }
                    i++;
                }
            }
        }

        if (i != pattern.length()) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        CheckStringPattern checkStringPattern = new CheckStringPattern();
        System.out.println(checkStringPattern.checkStringWithPattern("北京 杭州 杭州 北京", "abba"));
        System.out.println(checkStringPattern.checkStringWithPattern("北京 杭州 杭州 北京", "aabb"));
        System.out.println(checkStringPattern.checkStringWithPattern("北京 杭州 杭州 北京", "baab"));
        System.out.println(checkStringPattern.checkStringWithPattern("北京 杭州 上海 北京", "baab"));
        System.out.println(checkStringPattern.checkStringWithPattern("北京 杭州 上海 北京", "bacb"));
    }

}
