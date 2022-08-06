package it.saimao.tainueaconverter;

class TaiZawgyiConverter {
    static String uni2zg(String input) {
        String output = input;
        // For asai and esai
        output = output.replaceAll("([\\u1000-\\u1021\\u1075-\\u1081\\u1022\\u108f\\u1029\\u106e\\u106f\\u1086\\u1090\\u1091\\u1092\\u1097\\u1029])((?:\\u1039[\\u1000-\\u1021])?)((?:[\\u103b-\\u103e\\u1087]*)?)\\u1031", "\u1031$1$2$3");
        output = output.replaceAll("([\\u1000-\\u1021\\u1075-\\u1081\\u1022\\u108f\\u1029\\u106e\\u106f\\u1086\\u1090\\u1091\\u1092\\u1097\\u1029])((?:\\u1039[\\u1000-\\u1021])?)((?:[\\u103b-\\u103e\\u1087]*)?)\\u1084", "\uaa2c$1$2$3");
        // Shan consonants omit Burma ones
        output = output.replaceAll("\\u1075", "\uaa00");
        output = output.replaceAll("\\u1076", "\uaa01");
        output = output.replaceAll("\\u1078", "\uaa05");
        output = output.replaceAll("\\u107a", "\uaa09");
        output = output.replaceAll("\\u107c", "\uaa13");
        output = output.replaceAll("\\u107d", "\uaa15");
        output = output.replaceAll("\\u107e", "\uaa18");
        output = output.replaceAll("\\u1081", "\uaa1f");
        output = output.replaceAll("\\u1022", "\uaa21");

        // Vowels and others
        output = output.replaceAll("\\u1087", "\uaa32");
        output = output.replaceAll("\\u1088", "\uaa33");
        output = output.replaceAll("\\u1089", "\uaa35");
        output = output.replaceAll("\\u108a", "\uaa36");
        output = output.replaceAll("\\u1084", "\uaa2c");
        output = output.replaceAll("\\u1035", "\uaa31");
        output = output.replaceAll("\\u1085", "\uaa30");
        output = output.replaceAll("\\u1062", "\uaa24");
        output = output.replaceAll("\\u1083", "\uaa23");
        output = output.replaceAll("\\u1082", "\uaa2e");
        output = output.replaceAll("\\u1086", "\uaa2f");
        // Shan Numbers
        output = output.replaceAll("\\u1091", "\uaa3c");
        output = output.replaceAll("\\u1092", "\uaa3d");
        output = output.replaceAll("\\u1093", "\uaa3e");
        output = output.replaceAll("\\u1094", "\uaa3f");
        output = output.replaceAll("\\u1095", "\uaa40");
        output = output.replaceAll("\\u1096", "\uaa41");
        output = output.replaceAll("\\u1097", "\uaa42");
        output = output.replaceAll("\\u1098", "\uaa43");
        output = output.replaceAll("\\u1099", "\uaa44");
        output = output.replaceAll("\\u1090", "\uaa3b");
        // Pali characters for Shan unicode
        output = output.replaceAll("\\uaa61", "\uaa07");
        output = output.replaceAll("\\u107b", "\uaa11");
        output = output.replaceAll("\\ua9e3", "\uaa0e");
        output = output.replaceAll("\\ua9e3", "\uaa0e");
        output = output.replaceAll("\\u107f", "\uaa16");
        output = output.replaceAll("\\u1077", "\uaa02");
        output = output.replaceAll("\\uaa6a", "\uaa12");
        output = output.replaceAll("\\ua9e0", "\uaa03");
        output = output.replaceAll("\\uaa6e", "\uaa20");

        // For others

        output = output.replaceAll("\\u103a", "\u1039");
        output = output.replaceAll("\\u103b", "\u103a");
        output = output.replaceAll("\\u103c", "\u103b");
        output = output.replaceAll("\\u103d", "\u103c");
        output = output.replaceAll("\\u103e", "\u103d");

        return output;
    }
    static String zg2uni(String input) {
        String output = input;
        output = output.replaceAll("\\u103c", "\u103d");
        output = output.replaceAll("\\u1039", "\u103a");
        output = output.replaceAll("(\\u1094|\\u1095)", "\u1037");
        output = output.replaceAll("\\u1031\\u1047", "\u1031\u101b");
        output = output.replaceAll("\\u1040(\\u102e|\\u102f|\\u102d\\u102f|\\u1030|\\u1036|\\u103d|\\u103e)", "\u101d$1");
        output = output.replaceAll("\\u1031([\\u1000-\\u1022\\uaa00-\\uaa21])", "$1\u1031");
        output = output.replaceAll("\\uaa2c([\\u1000-\\u1022\\uaa00-\\uaa21])", "$1\uaa2c");
        output = output.replaceAll("([\\u102d\\u102e])\\u103b", "\u103b$1");
        output = output.replaceAll("(\\u102f|\\u1030)(\\u102d|\\u102e)", "$2$1");
        output = output.replaceAll("[\\u102d]+", "\u102d");
        output = output.replaceAll("[\\u103a]+", "\u103a");
        output = output.replaceAll("[\\u102e]+", "\u102e");
        output = output.replaceAll("\\u102f\\u102d", "\u102d\u102f");
        output = output.replaceAll("\\uaa00", "\u1075");
        output = output.replaceAll("\\uaa01", "\u1076");
        output = output.replaceAll("\\uaa05", "\u1078");
        output = output.replaceAll("\\uaa09", "\u107a");
        output = output.replaceAll("\\uaa13", "\u107c");
        output = output.replaceAll("\\uaa15", "\u107d");
        output = output.replaceAll("\\uaa18", "\u107e");
        output = output.replaceAll("\\uaa1f", "\u1081");
        output = output.replaceAll("\\uaa21", "\u1022");
        output = output.replaceAll("\\uaa32", "\u1087");
        output = output.replaceAll("\\uaa33", "\u1088");
        output = output.replaceAll("\\uaa35", "\u1089");
        output = output.replaceAll("\\uaa36", "\u108a");
        output = output.replaceAll("\\uaa2c", "\u1084");
        output = output.replaceAll("\\uaa31", "\u1035");
        output = output.replaceAll("\\uaa30", "\u1085");
        output = output.replaceAll("\\uaa24", "\u1062");
        output = output.replaceAll("\\uaa23", "\u1083");
        output = output.replaceAll("\\uaa2e", "\u1082");
        output = output.replaceAll("\\uaa2f", "\u1086");
        output = output.replaceAll("\\uaa3c", "\u1091");
        output = output.replaceAll("\\uaa3d", "\u1092");
        output = output.replaceAll("\\uaa3e", "\u1093");
        output = output.replaceAll("\\uaa3f", "\u1094");
        output = output.replaceAll("\\uaa40", "\u1095");
        output = output.replaceAll("\\uaa41", "\u1096");
        output = output.replaceAll("\\uaa42", "\u1097");
        output = output.replaceAll("\\uaa43", "\u1098");
        output = output.replaceAll("\\uaa44", "\u1099");
        output = output.replaceAll("\\uaa3b", "\u1090");
        output = output.replaceAll("\\uaa07", "\uaa61");
        output = output.replaceAll("\\uaa11", "\u107b");
        output = output.replaceAll("\\uaa0e", "\ua9e3");
        output = output.replaceAll("\\uaa02", "\u1077");
        output = output.replaceAll("\\uaa12", "\uaa6a");
        output = output.replaceAll("\\uaa03", "\ua9e0");
        output = output.replaceAll("\\uaa20", "\uaa6e");
        return output;
    }
}
