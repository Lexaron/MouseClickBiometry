/*
 *  Project name: Biometrija_Klika_Trainer_DIPLOMSKI/Brain.java
 *  Author & email: Mirza Suljić <mirza.suljic.ba@gmail.com>
 *  Date & time: Mar 15, 2016, 12:54:42 AM
 */
package trainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.swing.JTextArea;

/**
 *
 * @author Mirza Suljić <mirza.suljic.ba@gmail.com>
 */
public class Brain {

    public String printEvents(List<Integer> events) {
        String r = "";
        for (int temp : events) {
            r += temp;
        }
        return r;
    }

    public double avgClickDuration(ArrayList<Long> durationList) {
        double result = 0;
        for (long temp : durationList) {
            result += temp;
        }
        result = (result / durationList.size()) / 1000.00;

        return result;

    }

    public void printEventAndDuration(List<Integer> events, ArrayList<Long> durationList, JTextArea jta) {
        jta.setText("");
        int size = events.size();
        for (int i = 0; i < size; i++) {
            if (Objects.equals(Collections.min(durationList), durationList.get(i)) || Objects.equals(Collections.max(durationList), durationList.get(i))) {
                jta.append("\t" + events.get(i) + " : " + (durationList.get(i) / 1000.00) + "\n");
            } else {
                jta.append(events.get(i) + " : " + (durationList.get(i) / 1000.00) + "\n");
            }

        }
    }

    public double[] avgBigramDuration(List<Integer> events, ArrayList<Long> eventDuration) {
        double[] avgDur;
        double count00 = 0;
        double count01 = 0;
        double count10 = 0;
        double count11 = 0;
        Object[] tempEvents = events.toArray();
        for (int i = 0; i < tempEvents.length - 1; i++) {
            if ((int) tempEvents[i] == 0 && (int) tempEvents[i + 1] == 0) {
                count00 = count00 + (eventDuration.get(i) + eventDuration.get(i + 1));
            } else if ((int) tempEvents[i] == 0 && (int) tempEvents[i + 1] == 1) {
                count01 = count01 + (eventDuration.get(i) + eventDuration.get(i + 1));
            } else if ((int) tempEvents[i] == 1 && (int) tempEvents[i + 1] == 0) {
                count10 = count10 + (eventDuration.get(i) + eventDuration.get(i + 1));
            } else if ((int) tempEvents[i] == 1 && (int) tempEvents[i + 1] == 1) {
                count11 = count11 + (eventDuration.get(i) + eventDuration.get(i + 1));
            }
        }
        count00 = (count00 / countBigrams(events)[0]) / 1000.0;
        count01 = (count01 / countBigrams(events)[1]) / 1000.0;
        count10 = (count10 / countBigrams(events)[2]) / 1000.0;
        count11 = (count11 / countBigrams(events)[3]) / 1000.0;
        avgDur = new double[]{count00, count01, count10, count11};
        return avgDur;
    }
    
    public double[] maxBigramDuration(List<Integer> events, ArrayList<Long> eventDuration) {
        double[] maxDur;
        double count00 = 0;
        double count01 = 0;
        double count10 = 0;
        double count11 = 0;
        Object[] tempEvents = events.toArray();
        for (int i = 0; i < tempEvents.length - 1; i++) {
            if ((int) tempEvents[i] == 0 && (int) tempEvents[i + 1] == 0) {
                if (count00 < (eventDuration.get(i) + eventDuration.get(i + 1))) {
                    count00 = (eventDuration.get(i) + eventDuration.get(i + 1));
                }                
            } else if ((int) tempEvents[i] == 0 && (int) tempEvents[i + 1] == 1) {
                if (count01 < (eventDuration.get(i) + eventDuration.get(i + 1))) {
                    count01 = (eventDuration.get(i) + eventDuration.get(i + 1));
                }  
            } else if ((int) tempEvents[i] == 1 && (int) tempEvents[i + 1] == 0) {
                if (count10 < (eventDuration.get(i) + eventDuration.get(i + 1))) {
                    count10 = (eventDuration.get(i) + eventDuration.get(i + 1));
                }  
            } else if ((int) tempEvents[i] == 1 && (int) tempEvents[i + 1] == 1) {
                if (count11 < (eventDuration.get(i) + eventDuration.get(i + 1))) {
                    count11 = (eventDuration.get(i) + eventDuration.get(i + 1));
                }  
            }
        }
        count00 = count00 / 1000.0;
        count01 = count01 / 1000.0;
        count10 = count10 / 1000.0;
        count11 = count11 / 1000.0;
        maxDur = new double[]{count00, count01, count10, count11};
        return maxDur;
    }
    
    public double[] minBigramDuration(List<Integer> events, ArrayList<Long> eventDuration) {
        double[] minDur;
        double count00 = 999999999;
        double count01 = 999999999;
        double count10 = 999999999;
        double count11 = 999999999;
        Object[] tempEvents = events.toArray();
        for (int i = 0; i < tempEvents.length - 1; i++) {
            if ((int) tempEvents[i] == 0 && (int) tempEvents[i + 1] == 0) {
                if (count00 > (eventDuration.get(i) + eventDuration.get(i + 1))) {
                    count00 = (eventDuration.get(i) + eventDuration.get(i + 1));
                }                
            } else if ((int) tempEvents[i] == 0 && (int) tempEvents[i + 1] == 1) {
                if (count01 > (eventDuration.get(i) + eventDuration.get(i + 1))) {
                    count01 = (eventDuration.get(i) + eventDuration.get(i + 1));
                }  
            } else if ((int) tempEvents[i] == 1 && (int) tempEvents[i + 1] == 0) {
                if (count10 > (eventDuration.get(i) + eventDuration.get(i + 1))) {
                    count10 = (eventDuration.get(i) + eventDuration.get(i + 1));
                }  
            } else if ((int) tempEvents[i] == 1 && (int) tempEvents[i + 1] == 1) {
                if (count11 > (eventDuration.get(i) + eventDuration.get(i + 1))) {
                    count11 = (eventDuration.get(i) + eventDuration.get(i + 1));
                }  
            }
        }
        count00 = count00 / 1000.0;
        count01 = count01 / 1000.0;
        count10 = count10 / 1000.0;
        count11 = count11 / 1000.0;
        minDur = new double[]{count00, count01, count10, count11};
        return minDur;
    }
    
    public int[] countOnesZeroes(List<Integer> events) {
        int results[] = new int[2];
        int ones = 0;
        int zeros = 0;
        for (int temp : events) {
            if (temp == 0) {
                zeros++;
            } else {
                ones++;
            }
        }
        results[0] = zeros;
        results[1] = ones;
        return results;
    }

    public int[] countBigrams(List<Integer> events) {
        //0 00 | 3 11
        //1 01
        //2 10
        int[] results = new int[4];
        for (int i = 0; i < events.toArray().length - 1; i++) {
            String bigram
                    = events.toArray()[i].toString()
                    + events.toArray()[i + 1].toString();
            switch (bigram) {
                case "00":
                    results[0]++;
                    break;
                case "01":
                    results[1]++;
                    break;
                case "10":
                    results[2]++;
                    break;
                case "11":
                    results[3]++;
                    break;
                default:
                    System.out.println("Unsupported bigram: " + bigram);
                    break;
            }
        }
        return results;
    }

    public int[] countTrigrams(List<Integer> events) {
        //0 000 | 3 100 | 6 101
        //1 001 | 4 011 | 7 111
        //2 010 | 5 110 |
        int[] results = new int[8];
        for (int i = 0; i < events.toArray().length - 2; i++) {
            String trigram
                    = events.toArray()[i].toString()
                    + events.toArray()[i + 1].toString()
                    + events.toArray()[i + 2].toString();
            switch (trigram) {
                case "000":
                    results[0]++;
                    break;
                case "001":
                    results[1]++;
                    break;
                case "010":
                    results[2]++;
                    break;
                case "100":
                    results[3]++;
                    break;
                case "011":
                    results[4]++;
                    break;
                case "110":
                    results[5]++;
                    break;
                case "101":
                    results[6]++;
                    break;
                case "111":
                    results[7]++;
                    break;
                default:
                    System.out.println("Unsupported trigram: " + trigram);
                    break;
            }
        }
//                += "000: " + results[0] + "\n"
//                + "001: " + results[1] + "\n"
//                + "010: " + results[2] + "\n"
//                + "100: " + results[3] + "\n"
//                + "011: " + results[4] + "\n"
//                + "110: " + results[5] + "\n"
//                + "101: " + results[6] + "\n"
//                + "111: " + results[7] + "\n";
        return results;
    }

    public int[] countFourgrams(List<Integer> events) {
        String string = "";
        //0 0000 | 4 1000 | 8  0101 | 12 1011
        //1 0001 | 5 0011 | 9  1010 | 13 1110
        //2 0010 | 6 0110 | 10 1001 | 14 0111
        //3 0100 | 7 1100 | 11 1101 | 15 1111
        int[] results = new int[16];
        for (int i = 0; i < events.toArray().length - 3; i++) {
            String fourgram
                    = events.toArray()[i].toString()
                    + events.toArray()[i + 1].toString()
                    + events.toArray()[i + 2].toString()
                    + events.toArray()[i + 3].toString();
            switch (fourgram) {
                case "0000":
                    results[0]++;
                    break;
                case "0001":
                    results[1]++;
                    break;
                case "0010":
                    results[2]++;
                    break;
                case "0100":
                    results[3]++;
                    break;
                case "1000":
                    results[4]++;
                    break;
                case "0011":
                    results[5]++;
                    break;
                case "0110":
                    results[6]++;
                    break;
                case "1100":
                    results[7]++;
                    break;
                case "0101":
                    results[8]++;
                    break;
                case "1010":
                    results[9]++;
                    break;
                case "1001":
                    results[10]++;
                    break;
                case "1101":
                    results[11]++;
                    break;
                case "1011":
                    results[12]++;
                    break;
                case "1110":
                    results[13]++;
                    break;
                case "0111":
                    results[14]++;
                    break;
                case "1111":
                    results[15]++;
                    break;
                default:
                    System.out.println("Unsupported fourgram: " + fourgram);
                    break;
            }
        }
        string
                += "0000: " + results[0] + "\n"
                + "0001: " + results[1] + "\n"
                + "0010: " + results[2] + "\n"
                + "0100: " + results[3] + "\n"
                + "1000: " + results[4] + "\n"
                + "0011: " + results[5] + "\n"
                + "0110: " + results[6] + "\n"
                + "1100: " + results[7] + "\n"
                + "0101: " + results[8] + "\n"
                + "1010: " + results[9] + "\n"
                + "1001: " + results[10] + "\n"
                + "1101: " + results[11] + "\n"
                + "1011: " + results[12] + "\n"
                + "1110: " + results[13] + "\n"
                + "0111: " + results[14] + "\n"
                + "1111: " + results[15] + "\n";
        return results;
    }

}
