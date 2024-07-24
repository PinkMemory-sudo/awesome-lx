package com.example.springdemo.demos.web.webservice;

public class TT {
    public static void main(String[] args) {
        String s="INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (NULL, 'COM004', '静脉推注', '静脉推注', 1, NULL, NULL, 1, NULL, NULL, NULL, NULL);";

        String useWay="灌肠\n" +
                "膀胱冲洗\n" +
                "静脉高营养\n" +
                "皮内注射\n" +
                "前列腺注射\n" +
                "头皮静脉注射\n" +
                "眼球后注射\n" +
                "半球后注射\n" +
                "静脉大化疗\n" +
                "静脉小化疗\n" +
                "含服\n" +
                "吸入\n" +
                "局麻\n" +
                "化疗\n" +
                "左球结下注射\n" +
                "置阴道\n" +
                "涂鼻\n" +
                "喷喉\n" +
                "湿敷\n" +
                "术前\n" +
                "咀嚼\n" +
                "冲服\n" +
                "关节腔内注射\n" +
                "右球结膜下注射\n" +
                "小儿静脉滴注\n" +
                "带手术室用\n" +
                "口服(术前半小时)\n" +
                "静滴(术前半小时)\n" +
                "肌肉注射(术前半小时)\n" +
                "喷雾\n" +
                "气道冲洗\n" +
                "静脉推注泵\n" +
                "气管滴入\n" +
                "鞘内注射\n" +
                "T管冲洗\n" +
                "ivgtt(不收费)\n" +
                "静脉推注(5ml)\n" +
                "点左耳\n" +
                "术后镇痛PCA\n" +
                "未加药接瓶\n" +
                "穴位注射\n" +
                "宫内注射\n" +
                "舌下含服\n" +
                "胃管注入\n" +
                "点左眼\n" +
                "点右眼\n" +
                "点双眼\n" +
                "点右耳\n" +
                "点双耳\n" +
                "滴鼻前庭\n" +
                "皮下注射\n" +
                "皮试\n" +
                "结膜下注射\n" +
                "泪道冲洗\n" +
                "抗肿瘤化学药物配置\n" +
                "鞘内注射(不收费)\n" +
                "蒸气雾化吸入\n" +
                "阴道上药\n" +
                "阴道擦洗\n" +
                "阴道冲洗\n" +
                "通液\n" +
                "CVP用\n" +
                "颈丛\n" +
                "硬膜外腔\n" +
                "压疮冲洗\n" +
                "膀胱灌注\n" +
                "肠腔灌注\n" +
                "腹腔冲洗\n" +
                "肠腔化疗\n" +
                "腹腔化疗\n" +
                "胸腔引流\n" +
                "腹腔引流\n" +
                "肌注(出院带药)\n" +
                "肺内灌洗\n" +
                "肌肉注射(2ml)\n" +
                "肌肉注射(5ml)\n" +
                "肌肉注射(6岁以下)\n" +
                "胰岛素皮下注射\n" +
                "超声雾化(15分钟)\n" +
                "超声雾化吸入\n" +
                "封管用\n" +
                "雾化吸入(带药)\n" +
                "雾化吸入(新生儿)\n" +
                "雾化熏眼\n" +
                "静脉滴注\n" +
                "静脉注射(6岁以下)\n" +
                "静脉输液(营养输液器)\n" +
                "静脉输液(超低密度)\n" +
                "静脉输液(避光3.0)\n" +
                "静脉输液(避光5.0)\n" +
                "静脉推注(10ml)\n" +
                "静脉推注(20ml)\n" +
                "静脉推注(2ml)\n" +
                "静脉推注(50ml)\n" +
                "静滴(出院带药)\n" +
                "球旁注射\n" +
                "皮下注射(不收注射器)\n" +
                "皮下注射(不收费)\n" +
                "餐中口服\n" +
                "餐后口服\n" +
                "点气管\n" +
                "点术眼\n" +
                "餐前口服\n" +
                "淋巴管灌注\n" +
                "灌肠(6周岁以下)\n" +
                "洗眼\n" +
                "滴眼\n" +
                "清洁灌肠\n" +
                "清洁灌肠(6周岁以下)\n" +
                "漱口\n" +
                "洗胃\n" +
                "酒精擦浴\n" +
                "滴鼻\n" +
                "滴斗入\n" +
                "ivgtto\n" +
                "蛛网膜下腔\n" +
                "中药薰洗\n" +
                "口服\n" +
                "吸氧用\n" +
                "喷鼻\n" +
                "吸痰用\n" +
                "输液接瓶(1ml)\n" +
                "输液接瓶(20ml)\n" +
                "输液接瓶(20ml+1ml)\n" +
                "输液接瓶(50ml)\n" +
                "输液接瓶(50ml)\n" +
                "输液接瓶(50ml+1ml)\n" +
                "输液接瓶(无注射器)\n" +
                "输液接瓶带过滤(20ml)\n" +
                "置鼻管滴入\n" +
                "贴胸\n" +
                "贴心前区\n" +
                "局部封闭\n" +
                "臂丛\n" +
                "塞肛\n" +
                "外用\n" +
                "外洗\n" +
                "换药用\n" +
                "气管内\n" +
                "气道湿化\n" +
                "氧化雾化\n" +
                "术中用\n" +
                "检查用\n" +
                "备用\n" +
                "备肠用\n" +
                "造影用\n" +
                "to CT\n" +
                "鼻饲\n" +
                "透析\n" +
                "血透用\n" +
                "造瘘管注入\n" +
                "交替滴眼\n" +
                "冲管用\n" +
                "坐浴\n" +
                "引计用\n" +
                "离子透入\n" +
                "高压泵雾化吸入\n" +
                "静脉滴注（冲管）\n" +
                "泵入\n" +
                "肌肉注射\n" +
                "气管内滴入\n" +
                "鼻肠管泵入\n" +
                "胃管泵入\n" +
                "输液泵泵入\n" +
                "静脉推注\n" +
                "胃造瘘管\n" +
                "鼻肠管\n" +
                "鼻胃管\n" +
                "空肠造瘘管\n" +
                "十二指肠造管\n" +
                "鼻肠管肠腔\n" +
                "鼻肠管胃腔\n" +
                "胃肠注入\n" +
                "鼻肠管注入\n" +
                "鼻肠管给药\n" +
                "静脉滴注（不收费）\n" +
                "输液接瓶（避光）\n" +
                "静脉注射\n" +
                "静脉推送（2ml）不收费\n" +
                "皮内注射（无注射器）\n" +
                "输液泵\n" +
                "肌肉注射(不收费)\n" +
                "术腔冲洗\n" +
                "高压团注\n" +
                "血液净化\n" +
                "超声雾化吸入（不收费）\n" +
                "膀胱灌注（不收费）\n" +
                "雾化\n" +
                "雾化吸入（不收费）\n" +
                "玻璃体内注射\n" +
                "透中使用（不收费）";
        for (String string : useWay.split("\n")) {
            System.out.println(s.replaceAll("静脉推注",string));
        }
       String code= "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (540, 'COM004', '静脉推注', '静脉推注', 1, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (541, 'COM004', '皮下注射', '皮下注射', 2, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (542, 'COM004', '皮内注射', '皮内注射', 3, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (543, 'COM004', '微泵', '微泵', 4, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (544, 'COM004', '静脉滴注', '静脉滴注', 5, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (545, 'COM004', '口服', '口服', 6, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (546, 'COM004', '鼻饲', '鼻饲', 7, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (547, 'COM004', '静脉滴注(冲管)', '静脉滴注(冲管)', 8, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (548, 'COM004', '泵入', '泵入', 9, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (549, 'COM004', '肌肉注射', '肌肉注射', 10, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (550, 'COM004', '气管内滴入', '气管内滴入', 11, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (551, 'COM004', '鼻肠管泵入', '鼻肠管泵入', 12, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (552, 'COM004', '胃管泵入', '胃管泵入', 13, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n" +
               "INSERT INTO `eicu_fy`.`med_sys_combo_box_value_config`(`primary_id`, `combo_id`, `combo_value`, `combo_sign`, `combo_sort`, `score`, `term`, `status`, `creator`, `create_time`, `updater`, `update_time`) VALUES (553, 'COM004', '输液泵泵入', '输液泵泵入', 14, NULL, NULL, 1, NULL, NULL, NULL, NULL);\n";

    }


}
