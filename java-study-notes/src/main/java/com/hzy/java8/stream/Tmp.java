package com.hzy.java8.stream;

public class Tmp {

    public static void main(String[] args) {
        int num = 4;
        String firstColumn = "pid as ppid, m_001t, m_002t, m_001p, m_002p, m_003q, m_006q, m_003qc/3.6*1000 as m_003qc, m_006qc, " +
                "m_001sw, m_001opening, m_003opening, m_001waterlevel, aligntime, m_001com, m_020qc,m_001elec,m_079q as m_079q_first";
//        //是否有水泵频率
//        String needPumpColumn = sysConfigService.selectConfigByKey("needPumpColumn");
//        if (StringUtils.isBlank(needPumpColumn) || "true".equals(needPumpColumn) || "1".equals(needPumpColumn)) {
//            firstColumn = firstColumn + ", m_001f, m_003f";
//            map.put("needPumpColumn", 1);
//        }
        String secColumn = "";
        String m004tColumn = ",case p.partition_id";
        String m004pColumn = ",case p.partition_id";
        String m005tColumn = ",case p.partition_id";
        String m005pColumn = ",case p.partition_id";
        String m039qColumn = ",case p.partition_id";
        String m039qcColumn = ",case p.partition_id";
        String m078qColumn = ",case p.partition_id";
        String m078qcColumn = ",case p.partition_id";
        String m079qColumn = ",case p.partition_id";
        String m040qColumn = ",case p.partition_id ";
        String m001PowerColumn = ",case p.partition_id ";
        String m001SumColumn = ",case p.partition_id ";
        if (num > 1) {
            for (int i = 1; i <= num; i++) {
                secColumn += ",m_004t_" + i + ", m_005t_" + i + ", m_004p_" + i + ", m_005p_" + i + ", m_039q_" + i
                        + ", m_039qc_" + i + ", m_040q_" + i + ", m_078q_" + i + ", m_078qc_" + i
                        + ", m_079q_" + i + ",m_001elecpower_" + i + ",m_001elecsum_" + i;
                m004tColumn += " when " + i + " then m_004t_" + i;
                m004pColumn += " when " + i + " then m_004p_" + i;
                m005tColumn += " when " + i + " then m_005t_" + i;
                m005pColumn += " when " + i + " then m_005p_" + i;
                m039qColumn += " when " + i + " then m_039q_" + i;
                m039qcColumn += " when " + i + " then m_039qc_" + i;
                m040qColumn += " when " + i + " then m_040q_" + i;
                m078qColumn += " when " + i + " then m_078q_" + i;
                m078qcColumn += " when " + i + " then m_078qc_" + i;
                m079qColumn += " when " + i + " then m_079q_" + i;
                m001PowerColumn += " when " + i + " then m_001elecpower_" + i;
                m001SumColumn += " when " + i + " then m_001elecsum_" + i;
            }
            m004tColumn += " end m_004t";
            m004pColumn += " end m_004p";
            m005tColumn += " end m_005t";
            m005pColumn += " end m_005p";
            m039qColumn += " end m_039q";
            m039qcColumn += " end m_039qc";
            m040qColumn += " end m_040q";
            m078qColumn += " end m_078q";
            m078qcColumn += " end m_078qc";
            m079qColumn += " end m_079q";
            m001PowerColumn += " end m_001elecpower";
            m001SumColumn += " end m_001elecsum";
        } else {
            secColumn += ",m_004t_1, m_005t_1, m_004p_1, m_005p_1,m_039q_1,m_039qc_1,m_040q_1,m_078q_1,m_078qc_1," +
                    "m_079q_1,m_001elecpower_1,m_001elecsum_1";
            m004tColumn = ",m_004t_1 as m_004t";
            m004pColumn = ",m_004p_1 as m_004p";
            m005tColumn = ",m_005t_1 as m_005t";
            m005pColumn = ",m_005p_1 as m_005p ";
            m039qColumn = ",m_039q_1 as m_039q ";
            m039qcColumn = ",m_039qc_1 as m_039qc ";
            m040qColumn = ",m_040q_1 as m_040q ";
            m078qColumn = ",m_078q_1 as m_078q ";
            m078qcColumn = ",m_078qc_1 as m_078qc ";
            m079qColumn = ",m_079q_1 as m_079q ";
            m001PowerColumn = ",m_001elecpower_1 as m_001elecpower ";
            m001SumColumn = ",m_001elecsum_1 as m_001elecsum ";
        }
        System.out.println("column is :" + firstColumn + secColumn);
        System.out.println("caseColumn is :" + m004tColumn + m005tColumn + m004pColumn + m005pColumn + m039qColumn + m039qcColumn
                + m040qColumn + m078qColumn + m078qcColumn + m079qColumn + m001PowerColumn + m001SumColumn);
    }

}
