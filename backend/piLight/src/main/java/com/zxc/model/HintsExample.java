package com.zxc.model;

import java.util.ArrayList;
import java.util.List;

public class HintsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HintsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Integer value) {
            addCriterion("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Integer value) {
            addCriterion("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Integer value) {
            addCriterion("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Integer value) {
            addCriterion("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Integer value) {
            addCriterion("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Integer> values) {
            addCriterion("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Integer> values) {
            addCriterion("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Integer value1, Integer value2) {
            addCriterion("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Integer value1, Integer value2) {
            addCriterion("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andOldYearIsNull() {
            addCriterion("old_year is null");
            return (Criteria) this;
        }

        public Criteria andOldYearIsNotNull() {
            addCriterion("old_year is not null");
            return (Criteria) this;
        }

        public Criteria andOldYearEqualTo(Integer value) {
            addCriterion("old_year =", value, "oldYear");
            return (Criteria) this;
        }

        public Criteria andOldYearNotEqualTo(Integer value) {
            addCriterion("old_year <>", value, "oldYear");
            return (Criteria) this;
        }

        public Criteria andOldYearGreaterThan(Integer value) {
            addCriterion("old_year >", value, "oldYear");
            return (Criteria) this;
        }

        public Criteria andOldYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_year >=", value, "oldYear");
            return (Criteria) this;
        }

        public Criteria andOldYearLessThan(Integer value) {
            addCriterion("old_year <", value, "oldYear");
            return (Criteria) this;
        }

        public Criteria andOldYearLessThanOrEqualTo(Integer value) {
            addCriterion("old_year <=", value, "oldYear");
            return (Criteria) this;
        }

        public Criteria andOldYearIn(List<Integer> values) {
            addCriterion("old_year in", values, "oldYear");
            return (Criteria) this;
        }

        public Criteria andOldYearNotIn(List<Integer> values) {
            addCriterion("old_year not in", values, "oldYear");
            return (Criteria) this;
        }

        public Criteria andOldYearBetween(Integer value1, Integer value2) {
            addCriterion("old_year between", value1, value2, "oldYear");
            return (Criteria) this;
        }

        public Criteria andOldYearNotBetween(Integer value1, Integer value2) {
            addCriterion("old_year not between", value1, value2, "oldYear");
            return (Criteria) this;
        }

        public Criteria andOldMonthIsNull() {
            addCriterion("old_month is null");
            return (Criteria) this;
        }

        public Criteria andOldMonthIsNotNull() {
            addCriterion("old_month is not null");
            return (Criteria) this;
        }

        public Criteria andOldMonthEqualTo(Integer value) {
            addCriterion("old_month =", value, "oldMonth");
            return (Criteria) this;
        }

        public Criteria andOldMonthNotEqualTo(Integer value) {
            addCriterion("old_month <>", value, "oldMonth");
            return (Criteria) this;
        }

        public Criteria andOldMonthGreaterThan(Integer value) {
            addCriterion("old_month >", value, "oldMonth");
            return (Criteria) this;
        }

        public Criteria andOldMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_month >=", value, "oldMonth");
            return (Criteria) this;
        }

        public Criteria andOldMonthLessThan(Integer value) {
            addCriterion("old_month <", value, "oldMonth");
            return (Criteria) this;
        }

        public Criteria andOldMonthLessThanOrEqualTo(Integer value) {
            addCriterion("old_month <=", value, "oldMonth");
            return (Criteria) this;
        }

        public Criteria andOldMonthIn(List<Integer> values) {
            addCriterion("old_month in", values, "oldMonth");
            return (Criteria) this;
        }

        public Criteria andOldMonthNotIn(List<Integer> values) {
            addCriterion("old_month not in", values, "oldMonth");
            return (Criteria) this;
        }

        public Criteria andOldMonthBetween(Integer value1, Integer value2) {
            addCriterion("old_month between", value1, value2, "oldMonth");
            return (Criteria) this;
        }

        public Criteria andOldMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("old_month not between", value1, value2, "oldMonth");
            return (Criteria) this;
        }

        public Criteria andOldDayIsNull() {
            addCriterion("old_day is null");
            return (Criteria) this;
        }

        public Criteria andOldDayIsNotNull() {
            addCriterion("old_day is not null");
            return (Criteria) this;
        }

        public Criteria andOldDayEqualTo(Integer value) {
            addCriterion("old_day =", value, "oldDay");
            return (Criteria) this;
        }

        public Criteria andOldDayNotEqualTo(Integer value) {
            addCriterion("old_day <>", value, "oldDay");
            return (Criteria) this;
        }

        public Criteria andOldDayGreaterThan(Integer value) {
            addCriterion("old_day >", value, "oldDay");
            return (Criteria) this;
        }

        public Criteria andOldDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_day >=", value, "oldDay");
            return (Criteria) this;
        }

        public Criteria andOldDayLessThan(Integer value) {
            addCriterion("old_day <", value, "oldDay");
            return (Criteria) this;
        }

        public Criteria andOldDayLessThanOrEqualTo(Integer value) {
            addCriterion("old_day <=", value, "oldDay");
            return (Criteria) this;
        }

        public Criteria andOldDayIn(List<Integer> values) {
            addCriterion("old_day in", values, "oldDay");
            return (Criteria) this;
        }

        public Criteria andOldDayNotIn(List<Integer> values) {
            addCriterion("old_day not in", values, "oldDay");
            return (Criteria) this;
        }

        public Criteria andOldDayBetween(Integer value1, Integer value2) {
            addCriterion("old_day between", value1, value2, "oldDay");
            return (Criteria) this;
        }

        public Criteria andOldDayNotBetween(Integer value1, Integer value2) {
            addCriterion("old_day not between", value1, value2, "oldDay");
            return (Criteria) this;
        }

        public Criteria andScheduleDayIsNull() {
            addCriterion("schedule_day is null");
            return (Criteria) this;
        }

        public Criteria andScheduleDayIsNotNull() {
            addCriterion("schedule_day is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleDayEqualTo(Integer value) {
            addCriterion("schedule_day =", value, "scheduleDay");
            return (Criteria) this;
        }

        public Criteria andScheduleDayNotEqualTo(Integer value) {
            addCriterion("schedule_day <>", value, "scheduleDay");
            return (Criteria) this;
        }

        public Criteria andScheduleDayGreaterThan(Integer value) {
            addCriterion("schedule_day >", value, "scheduleDay");
            return (Criteria) this;
        }

        public Criteria andScheduleDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("schedule_day >=", value, "scheduleDay");
            return (Criteria) this;
        }

        public Criteria andScheduleDayLessThan(Integer value) {
            addCriterion("schedule_day <", value, "scheduleDay");
            return (Criteria) this;
        }

        public Criteria andScheduleDayLessThanOrEqualTo(Integer value) {
            addCriterion("schedule_day <=", value, "scheduleDay");
            return (Criteria) this;
        }

        public Criteria andScheduleDayIn(List<Integer> values) {
            addCriterion("schedule_day in", values, "scheduleDay");
            return (Criteria) this;
        }

        public Criteria andScheduleDayNotIn(List<Integer> values) {
            addCriterion("schedule_day not in", values, "scheduleDay");
            return (Criteria) this;
        }

        public Criteria andScheduleDayBetween(Integer value1, Integer value2) {
            addCriterion("schedule_day between", value1, value2, "scheduleDay");
            return (Criteria) this;
        }

        public Criteria andScheduleDayNotBetween(Integer value1, Integer value2) {
            addCriterion("schedule_day not between", value1, value2, "scheduleDay");
            return (Criteria) this;
        }

        public Criteria andBirthNameIsNull() {
            addCriterion("birth_name is null");
            return (Criteria) this;
        }

        public Criteria andBirthNameIsNotNull() {
            addCriterion("birth_name is not null");
            return (Criteria) this;
        }

        public Criteria andBirthNameEqualTo(String value) {
            addCriterion("birth_name =", value, "birthName");
            return (Criteria) this;
        }

        public Criteria andBirthNameNotEqualTo(String value) {
            addCriterion("birth_name <>", value, "birthName");
            return (Criteria) this;
        }

        public Criteria andBirthNameGreaterThan(String value) {
            addCriterion("birth_name >", value, "birthName");
            return (Criteria) this;
        }

        public Criteria andBirthNameGreaterThanOrEqualTo(String value) {
            addCriterion("birth_name >=", value, "birthName");
            return (Criteria) this;
        }

        public Criteria andBirthNameLessThan(String value) {
            addCriterion("birth_name <", value, "birthName");
            return (Criteria) this;
        }

        public Criteria andBirthNameLessThanOrEqualTo(String value) {
            addCriterion("birth_name <=", value, "birthName");
            return (Criteria) this;
        }

        public Criteria andBirthNameLike(String value) {
            addCriterion("birth_name like", value, "birthName");
            return (Criteria) this;
        }

        public Criteria andBirthNameNotLike(String value) {
            addCriterion("birth_name not like", value, "birthName");
            return (Criteria) this;
        }

        public Criteria andBirthNameIn(List<String> values) {
            addCriterion("birth_name in", values, "birthName");
            return (Criteria) this;
        }

        public Criteria andBirthNameNotIn(List<String> values) {
            addCriterion("birth_name not in", values, "birthName");
            return (Criteria) this;
        }

        public Criteria andBirthNameBetween(String value1, String value2) {
            addCriterion("birth_name between", value1, value2, "birthName");
            return (Criteria) this;
        }

        public Criteria andBirthNameNotBetween(String value1, String value2) {
            addCriterion("birth_name not between", value1, value2, "birthName");
            return (Criteria) this;
        }

        public Criteria andHintsIsNull() {
            addCriterion("hints is null");
            return (Criteria) this;
        }

        public Criteria andHintsIsNotNull() {
            addCriterion("hints is not null");
            return (Criteria) this;
        }

        public Criteria andHintsEqualTo(String value) {
            addCriterion("hints =", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsNotEqualTo(String value) {
            addCriterion("hints <>", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsGreaterThan(String value) {
            addCriterion("hints >", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsGreaterThanOrEqualTo(String value) {
            addCriterion("hints >=", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsLessThan(String value) {
            addCriterion("hints <", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsLessThanOrEqualTo(String value) {
            addCriterion("hints <=", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsLike(String value) {
            addCriterion("hints like", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsNotLike(String value) {
            addCriterion("hints not like", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsIn(List<String> values) {
            addCriterion("hints in", values, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsNotIn(List<String> values) {
            addCriterion("hints not in", values, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsBetween(String value1, String value2) {
            addCriterion("hints between", value1, value2, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsNotBetween(String value1, String value2) {
            addCriterion("hints not between", value1, value2, "hints");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}