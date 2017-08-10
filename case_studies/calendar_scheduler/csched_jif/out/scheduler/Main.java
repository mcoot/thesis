package scheduler;

import java.io.PrintStream;
import jif.runtime.Runtime;
import jif.util.LinkedList;
import jif.lang.Principal;
import jif.principals.Alice;
import jif.principals.Bob;
import jif.principals.Charles;

public class Main {
    private static Meeting meetingAliceBobAttend;
    
    public static void main(final String[] args) throws NullPointerException,
        IllegalArgumentException {
        final Principal p = Runtime.user(null);
        {
            PrintStream out1 = null;
            try {
                Runtime runtime = Runtime.getRuntime(p);
                out1 =
                  runtime ==
                    null
                    ? null
                    : runtime.stdout(
                                jif.lang.LabelUtil.singleton().noComponents());
            }
            catch (final SecurityException e) {  }
            PrintStream out2 = out1;
            PrintStream out = out2;
            if (out == null)
                throw new IllegalArgumentException("Out is null :(");
            out.println("Calendar scheduler" + "\n----------------\n");
            out.println("Initialising system...");
            Scheduler theScheduler = new Scheduler().scheduler$Scheduler$();
            Principal alice = ((Alice) Alice.getInstance()).getInstance();
            Principal bob = ((Bob) Bob.getInstance()).getInstance();
            Principal charles = ((Charles) Charles.getInstance()).getInstance();
            LinkedList allUsers =
              new LinkedList(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$util$LinkedList$();
            Main.setupDummyData(theScheduler, allUsers, alice, bob, charles);
            boolean scheduleCheck1 =
              theScheduler.attendeesFreeAtTime(
                             allUsers,
                             Meeting.getDayValue(
                                       jif.lang.PrincipalUtil.bottomPrincipal(),
                                       "Monday"),
                             9,
                             10);
            out.println("Are all users available at 9 - 10 on a Monday? " +
                        scheduleCheck1);
            boolean scheduleCheck2 =
              theScheduler.attendeesFreeAtTime(
                             allUsers,
                             Meeting.getDayValue(
                                       jif.lang.PrincipalUtil.bottomPrincipal(),
                                       "Tuesday"),
                             9,
                             10);
            out.println("Are all users available at 9 - 10 on a Tuesday? " +
                        scheduleCheck2);
            out.println();
            out.println("Alice prints her calendar:");
        }
    }
    
    private static void setupDummyData(final Scheduler theScheduler,
                                       final LinkedList allUsers,
                                       final Principal alice,
                                       final Principal bob,
                                       final Principal charles) {
        try {
            LinkedList aliceOnly =
              new LinkedList(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$util$LinkedList$();
            LinkedList bobOnly =
              new LinkedList(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$util$LinkedList$();
            LinkedList charlesOnly =
              new LinkedList(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$util$LinkedList$();
            LinkedList alicebob =
              new LinkedList(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$util$LinkedList$();
            LinkedList alicecharles =
              new LinkedList(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$util$LinkedList$();
            LinkedList bobcharles =
              new LinkedList(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$util$LinkedList$();
            theScheduler.addUser(alice);
            theScheduler.addUser(bob);
            theScheduler.addUser(charles);
            jif.lang.JifObjectWrapper aliceWrapper =
              new jif.lang.JifObjectWrapper(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$lang$JifObjectWrapper$(alice);
            jif.lang.JifObjectWrapper bobWrapper =
              new jif.lang.JifObjectWrapper(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$lang$JifObjectWrapper$(bob);
            jif.lang.JifObjectWrapper charlesWrapper =
              new jif.lang.JifObjectWrapper(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$lang$JifObjectWrapper$(charles);
            aliceOnly.add(aliceWrapper);
            bobOnly.add(bobWrapper);
            charlesOnly.add(charlesWrapper);
            alicebob.add(aliceWrapper);
            alicebob.add(bobWrapper);
            alicecharles.add(aliceWrapper);
            alicecharles.add(charlesWrapper);
            bobcharles.add(bobWrapper);
            bobcharles.add(charlesWrapper);
            allUsers.add(aliceWrapper);
            allUsers.add(bobWrapper);
            allUsers.add(charlesWrapper);
            theScheduler.addMeeting(
                           alice,
                           new Meeting(
                             alice).scheduler$Meeting$("Monday", 8, 10,
                                                       "Coming in late",
                                                       aliceOnly));
            theScheduler.addMeeting(
                           alice,
                           new Meeting(alice).scheduler$Meeting$("Monday", 12,
                                                                 13,
                                                                 "Lunch break",
                                                                 aliceOnly));
            theScheduler.addMeeting(
                           alice,
                           new Meeting(
                             alice).scheduler$Meeting$("Monday", 16, 18,
                                                       "Leaving early",
                                                       aliceOnly));
            theScheduler.addMeeting(
                           bob,
                           new Meeting(bob).scheduler$Meeting$("Monday", 7, 9,
                                                               "Long breaky",
                                                               bobOnly));
            theScheduler.addMeeting(
                           bob,
                           new Meeting(bob).scheduler$Meeting$("Monday", 13, 14,
                                                               "Nap time",
                                                               bobOnly));
            theScheduler.addMeeting(
                           charles,
                           new Meeting(
                             charles).scheduler$Meeting$(
                                        "Monday", 10, 11,
                                        "Important Serious Work", charlesOnly));
            Main.meetingAliceBobAttend =
              new Meeting(alice).scheduler$Meeting$("Monday", 10, 12,
                                                    "Catch up sesh", alicebob);
            theScheduler.addMeeting(alice, Main.meetingAliceBobAttend);
            theScheduler.addMeeting(bob, Main.meetingAliceBobAttend);
            Meeting m =
              new Meeting(
              alice).scheduler$Meeting$("Monday", 13, 14,
                                        "Alice\'s disciplinary hearing",
                                        alicecharles);
            theScheduler.addMeeting(alice, m);
            theScheduler.addMeeting(charles, m);
            m =
              new Meeting(bob).scheduler$Meeting$("Monday", 9, 10,
                                                  "Bob\'s disciplinary hearing",
                                                  bobcharles);
            theScheduler.addMeeting(bob, m);
            theScheduler.addMeeting(charles, m);
            m = new Meeting(alice).scheduler$Meeting$("Monday", 14, 15,
                                                      "Departmental meeting",
                                                      allUsers);
            theScheduler.addMeeting(alice, m);
            theScheduler.addMeeting(bob, m);
            theScheduler.addMeeting(charles, m);
        }
        catch (NullPointerException exc$0) { throw new Error(exc$0); }
    }
    
    public Main scheduler$Main$() {
        this.jif$init();
        {  }
        return this;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1502340092000L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAM1cC3gURbau6bwIr4TwCu8QwitghjdiUIEAEgiQJYAQ0NDp" +
       "6SQNnelhuicMKH74Al+Lu7zU3QXxE1hxuaDr9aqrsMjFBXyuu3pFXUVwPxcf" +
       "sPi6rJ+Ct86pmn5nGGB3v5vvS1VPdZ2qU+f8deqc0z2z6xTJ0KOkx2KlrsRY" +
       "HpH1kqlKXaUY1eVQpaYun02baqTvHnk19OD8yDGBZFaTFoo+J6yLdXIFyRZj" +
       "RoMWVYzlBsmtWCw2icGYoajBCkU3SitIK0kL60ZUVMKGvpTcQgIVJFehLWLY" +
       "UERDDk2Oao0G6V0RoRPVq5oRlONGMCJGxcYgshKsLFNFXacjZWJrYpAWkajW" +
       "pITkqEF6VVDGeW9VrJXVYCW/VwGfSuNRUpAYnq+PLQ5HZqvbOCi44YEbc3+b" +
       "RnKqSY4SrjJEQ5HKtLBB+akmrRvlxlo5qo8PheRQNWkXluVQlRxVRFVZQTtq" +
       "4WqSpyv1YdGIRWV9lqxrahN0zNNjEcoizJlorCCtmUhikqFFE8vJrFNkNZT4" +
       "lFGnivW6QTpZYmHLmwztVBYtqTjlaJ0oyQmS9CVKOASycFGYayyaRjtQ0qxG" +
       "merLnCo9LNIGksc0p4rh+mCVEVXC9bRrhhYzQMBdmx20FBQhSkvEernGIPnu" +
       "fpXsFu2VjYIAEoN0dHfDkaiWurq0ZNPPqRlj194UnhIWkOeQLKnAfwtK1NNF" +
       "NEuuk6NyWJIZYeviik1ip713CYTQzh1dnVmfZ27+ctzgnvsPsz7dfPrMrF0s" +
       "S0aNtK227ZvdywaOSWMQ1HQFlO9YOYK/kt8pjUfoxupkjgg3SxI398/6w/xV" +
       "j8ufC6RlOcmUNDXWSHHUTtIaI4oqR6+Tw3IUtkg5yZbDoTK8X06y6HWFEpZZ" +
       "68y6Ol02ykm6ik2ZGn6mIqqjQ4CIsui1Eq7TEtcR0WjA63iEEJJF/0k7+t+K" +
       "/n/B6xMGWRRs0BrloG7EQjLduEF9xPCRY4aMGBE0GmRd0YOSqMs1cFeR4YNK" +
       "ORGjNbrUIIdilPWghJc1sC/1qBS0bkynhqCENkf+DXPEYZ25ywIBqoLubgOg" +
       "0r0zRVOpkaiRNsQmTPpyd80rgrkhuIQM0tYctgSGJYEADtcBdgvTJtXFErqr" +
       "qbVrPbDqhqmL7ipMozCKLEunkoSuhQ6rWmZt/XK0ghLF35+vjSxaO7LbWIFk" +
       "VFPrqE+U68SYalSWTdBiYWpFOphNs2RqYMJo1nxNa1ZEQhqDdPYYRWYMKVnU" +
       "GgTIulHMF7l3nh+bOWtO/u+eTSs1aw8apMhjGryUsLUL3fKPahKVa1S2hi8u" +
       "EJ+u2buySCDp1F7QtRl0ZWB+errncGzx0oS5hLVk0OXVadFGUYVbCam0NBqi" +
       "2jKrBYHRFoo8hhHQqItBtLRXV0U2H3390+ECESyjnGM75Kpko9RmCGCwHNzy" +
       "7SyAzI7KMu33wYOV6zeeWrMA0UF79PGbsAjKMmoA6FFHJXjn4aXvHvtw21uC" +
       "hSiDnoOxWlWR4riWdj/SvwD9Pw//sJuhAWpq08u4JSkwTUkEZu5n8UaNikoN" +
       "G2VdL5oTbtRCSp0i1qoywPmHnL5Dn/5ibS5Tt0pbmPCiZPCFB7Dau0wgq165" +
       "8WxPHCYgwaFmyc/qxixle2vk8dGouBz4iN/6px4PHRI3U5tL7ZyurJDRdBGU" +
       "B0EFDkFZDMIy6Lo3DIoCumvdN+l03ay9iXuE+gUKcxpqpE5fFQYjkyd+hLpv" +
       "SeFYR30hRaJeTnfP1ioz78L+grO5PtG5h6dzuXUbdkZnNw98/vQbCkJfFRQu" +
       "wO3QKiTrUlSJJEBGLXlLXWmMqFTccgh3MfUhDG0qFZ/pEEXFsK5SrbOdPxtv" +
       "TopHonAcN4lR1BNKpTAOgDXZqAQ/q0Yafe+aqNbnnlECF2RbBjgquqGEF/S0" +
       "CLRO1HC3fQTKDnHqCoaYxSqISAVqwtRcBbjHiRK8WRK3+KuRNnd84IW836wb" +
       "zw7kXk4KT++xQ8pW14x48jXcJYCinm6RzpJFauiZzGukr7a8J88a+d1ptqu1" +
       "ZWG3Exmh/o+kRERwJPkV+J9RHAXWMZ5yle/BDh9+1E+37jn1YeU4BLxNS+Al" +
       "eBxVDgPTILHLic5zw+SnZLYWMVmqkW7s9MdB3V+Yf7ddTC4CW++1O3+V9ffB" +
       "323FZZtY6ePCikmQFC9QjmH8okFxKMjOpF1PnTt+8NbhpimnGbtuHPhRXDus" +
       "w76T+V1u4pqFCSfxWaEq91X29TQWsZRdUFJx4PdZs162KRs1SEWwDDsyfUI5" +
       "wVLATDpwXz95TtAMQ2u0SfXqPu8tLj335n8mdslkUyoDnQt0UdqXmVn8fJe1" +
       "76+amRhjKltqpW2ps1jTiEgcd9hc/HS1DubD5YlMEfUGetwcVd+p3vhBcU8m" +
       "bNtxxO//buKdGzc9+8wI5qzAJs69dhwhzDLC4OMiyMsCxkrEwYbr4wzWdRFT" +
       "UMRUjvMjq/NNx6i7wzGaDPGP5QxIK67+ZN35pdQZSKsmbRtEvTxMT1gIt2hU" +
       "BybW/GSQdrZthbYLXALV7t64YwTXZNXBXb/qWnbN57hjLc8DqHvFvb7jXNHm" +
       "FA17vPFboTDzJYFkUd8NPTIa2s4V1Rgc+tU0UtPLeGMFaeO474y6WIhRanpW" +
       "3d1ej21at89j+az0GnrDdUuX1W4Pur2S/udQ+a/i9QK71Q4QvFCRpDeWRVD0" +
       "R50JBnUvowo1GpTzTB0D5Lg5Op6peXzUal5X2EancV+jLBs0shxPd6Y8Qasd" +
       "bxjUp9cdRyAadznE4rLtj+3aXdp653bcu9moUapfgx93LYAi8Zktto3JDgY2" +
       "Heh/Bv2fxOsrDSL9y4IOtjYe2/w7pmGyHwFFI7MKy7lVgHKe755mnaG82TIx" +
       "jc697W2aYZHdmiKZO5tUFavVDVs8P2/A3Bfv6KLfy8zTQHOHyXGjBPM8nNRN" +
       "9+7RtGGtjKL7ERLptVSMmAeg+0GHngYpaD6ThGMx+94Kiia8vBtZ7kjNiC3U" +
       "Y1LGQM+zihqp3Zhf1tbdNu4Q2oscnBhxW8VY6GezRxZRUZWznzMt5bvuGunk" +
       "np8e7v3Z3PaYb0gs0R6ATBcjpe6AAyw8bc/Ieu/F/+606M00IkwmLVVNDE0W" +
       "MSwj2TQekvUGGv3GIxwggWUtYItz09zF5Qxa5m7UkcfT3pi7cDPbkrYgLd+5" +
       "aHuGiKemerrNdGJUlplCZSjmBu4IXBXxjTuH13i4LkOsx+OEWatN/tYqzQyU" +
       "TGNlUKOphEX1EiMnSj4T3Afde57QU72RHkhNPOck37Xhnh9L1m4QbIm5Pp7c" +
       "mJ3GJoI2UGwGB6J3slmQYvLf9qx8/rGVa9guynOmmSaFY43/8T/nXi158KMj" +
       "PpmNbNOpgaZ7nAeyVz+FH2etKT85dTseyLlwqKFLGGaIxqbysLOplaKb7g4u" +
       "bRsUOxjE+vt5V5Pi1CGjGrL5Vys+6til6FR1e/cK0NeKgJgGOf0szxh2T+tM" +
       "d+WJd4+cOWd6Wr62kmoaz6g4DF/kZwHcm3loqTTjgDZmIHKZaTQoetEQjHR9" +
       "DEEpM9Y/w8wDw/ByBsneUPQ1twD+ZfKk3HFev287Um0OFYazPZrLn6IGt922" +
       "YUto5vahibVvoxgwtMgVqtwkq7ahBI/xno4ZY8sIjH5kYlH3A0vX/vPyVfxI" +
       "90tN9XItys3Mzum7jlzXT1pHgWn6Tp4suJOo1OkxtWSzznb4TT1NNYBTQ7qx" +
       "PGlgM6832P0m1GQzThNcDoBiqctXasdHWs/r1W7FWukMgesFPhvmKG1glHzG" +
       "YOATXtvhAZDo6o6OxkfreYLhsTYvvXIqf/JhTDAIkgK5Ck8yLyQ3J7RYJCJH" +
       "7coTmhS4WoLiGG2y2cmPzb/a2TTINJi3UYtGGhSeLSjQ6gpYIq9AjNbHGqkX" +
       "VRCBRvb0oqCRoqhgQC1ML4cKxFqtSS6oXV5w08qBETN0M01CmRgOa4Ynb5Ap" +
       "KU+fCtaZxuAa5sk8B8VeplQo9iXTBhQHmWZfguIw0h3Blb1yceN5A4054SVh" +
       "GrGyQ6Wq1a7Y7XuvOJrgFs+JgXj5NpZ/9h8XO1i93oHiBYOkgwSxmRC/1Jgn" +
       "rObMcPB0CH6xeeY/TjyR4GY0WyQP0l9m1XuuRoMEeBh7EejA6qOUPNvjyMpf" +
       "LX/0uNdFPe71bBnZpymSuQPXCo3675Y5mn3foXdGPXRyHZ4EyaNQF6W6TT1U" +
       "8c3y1xMiVZw7vSsXzkm/nc4jtzP+Rihgej6IGVMNHL2WgLdamNruwTQU/0Bc" +
       "+6oB2l6F4lscD9mB4qzLbHVPOHawiK94/ZnDbJkzf09tw+yUbAO90FMwDyfu" +
       "2XZi9TowEgyRUL5JNwOQu5CJfA7k/J3145OGDIkkJ6UvqOW2MEBSAWsAn0IE" +
       "MsykFm1w5E28TTMsspYmMhN9bGB1NZ1mTQwigZxmIAKX3yTwweThOD0wiYE5" +
       "eWaODg3P37hm/dnONBCoJlk8yYHpjhlaGD/4PNC10Z/ZdezzP7XpsRtPHzOQ" +
       "a+l+Eu590O14fo0Mt2ZQsSDNry1d4gbqQv+z6Ur787qbQbrrSv0VEGC7H37z" +
       "MP5KFsYvlkPBZVp0SRDcuZCiG3iRjJZiI9/CBl10AazQTIQHOqcEkXzUdU9L" +
       "sfleXed77Bkn63MRZDT6zcX4EZZRwpYRiURIwL4VoTwHtMVwdT6S2PCBPAS9" +
       "Ca5Ae68+cM1QDMBhcazXU/JyMJHTm6ssyGvKb7FX/DNiqlqpIWAmxSUZH5Zw" +
       "RU6+OEU2N5IbV1cAczcw2yAM4jbie7uN4Gff1RFLqyNQGqMsXYzwqmeE7bjp" +
       "7T6JITthe4hUIz3SStm0d98b97MwsLtf/0TXHXlddqwbcKAC4/cWDaLeAD6e" +
       "QdrbMpE4tgxp/7aQsYNYWAvL3Glnuf8JpghKQAQLuQiKuQh+sIsA1nMN88ou" +
       "+NiwSjZW9Vj35v2/XDUncQwO9tkk6QzsTiZGcSbSm2OiDPvv5Ino30QSYR6z" +
       "t+ZgI30GE9I8B1TCKJt0Y4FuAu+fy+uWbiameZhIm6DVulgY7zdUzoVZmAJ0" +
       "s3j/Al53crNQ5WEhq6xBjKqy7mLjJ37D9bowG/N8MCH0c7OxwHxy5MoCTFxO" +
       "4wxFsiUB5pyb2u27U9MOsCQAvMLi9xR2vER1qVfSuyyTMtnJ0HzOSH8/higv" +
       "xc6gwc2FPXK4r7byqel/OR+zPbBxPH/joZbJD3p6Q8u7jh5b/V8HMIOSHaZR" +
       "dxTsDA2cVMXnJQeHd+gIvuI+3rk11yxNM0b+XN391MhPFzKD4I0Bzc5a+pjS" +
       "656f0k9wvM8Es+Sg4x1YBHadnDFdRgscC/yUPNAHHPHEEdPTOmL8DKyf4e/L" +
       "Df5wy/BPvThTXk4NTb2ojueOovtg+CeOZuXjqfk27b5p6wOlUFyL0DfwbmCc" +
       "n2lDS4WWwtqreKwvRNJlSHkD6gZnDIhsMMmlLviomLIvtGTf3Bpw+BLo/wIU" +
       "R+0RAV4/Sh3DJk0J2QJGK3a1gWx8zGgoM1M9NVLFt293ahqg/YE9EDf3uc2D" +
       "sx5SYbJlCMFnN8IWXq/yoMryGtJYttdp0nz9Koe5v1BX0yhfqGPCdKL0Vjuj" +
       "wzKRijpqF0Vh70WTDs+85nAqohgGM5RyEezk9dYkogjwR6sIEHOYMTDMVZz8" +
       "MV7/2j2MA0UPWSjCZT3g9nsgG0amEZa4eo3Xm+1j+vg9W3CsrZaTs8Xr9zia" +
       "AqXOYGwqn+hVXm9xnyjbk2wr1xFlRqEw0I7mBtyZmsfQx2+w7Rc+J4sTYIf+" +
       "v+X1LjcTT6biMQT9hnrywiyAn0PG8f4HeP2sm4XnUvUYrvUb7sULszHZT7+H" +
       "3Wy86II2Ul3Hex/xo/JA+2Cz51m5Hwuv+LB+EXb+tUu383+8ODtvECHSH9o8" +
       "iRcovnfkVKA8h2viQRyFNQT8QH8JcdwBlxly50cDQ5wSg+pDJjVfm+oryePm" +
       "I052hrEQJe/E1m1nb11zpQCvBmY0wUsV1N/JtfsZ8Nr+6l0be7Ta8BE+bI6s" +
       "n36y4ZK18rfUtMJ0QdUCpWpJQvNK4tTFSgJzfIETl7WMby5hGTdj+Zelpn8A" +
       "H2/x8QWg/TYo7mjmrIZ7a6C4F4r7cdwfkGw9FBuTnmtQPMR59hWazzFG14GT" +
       "/GgT/xYUv5BxAfFvtcS/AxqEFqmKfycUYIG59UTxH8AxWltLOZjERHHxH/aA" +
       "Rmh3kaAROlw+aIT8iwQN0j9n2ld8/agfwZgh51leOw5JKJM9RsNu7sdoeXyk" +
       "bbzeZBvRhaMMHIpp3IozMIczllO/zuvf2/littN5ZLoJHKeOQRallLQ2GuSq" +
       "xDsntuS1LhuxyMRYY+PyiaIhNveUC6Z62XrCJPQ0nzAJvZItHDr0tc4DAbeG" +
       "MABxNfCixoOPb/sVOOJQF5HtnWxhOBQ94NsVjqUisd/jKGh4jzHlfcJkbzRI" +
       "a7tQzY1DV4kLLE2ycbBxnKnm0dBYytX7Gq+PuPAqXIP9K51UV/LeL/tRYdeE" +
       "z2vSXeU326vN0c2wFMeSHJWswTG2t+m0E/TlfJr3/UDPHhcI0/z3o/NxgVfm" +
       "HGWWyGkI2t56v8rZ2Q5DKKoQis0ZNwHSz8JMHBo5hOInrk0NsQmR+Lq+5fUH" +
       "STb1DX4Ef3du6oWpPYlS1Tk6XdklbmhYTdAgLRLDWBCexyC8MHUI3wiNtXwx" +
       "3/D6jBvCNS4oIlUN7/2lH5U/hEW/2b5OCuF5yEC9hdd5XgjPawbCqGKVT3Pe" +
       "T8Ucws28zuqEsFPeCN+5cUvcq81pMS3VmV/czmvdIKXJEkmqUssSSfSafzk2" +
       "8aUxnoe6HHLkM2puM8g/uL6Zhvfuw/LnPi/8Qft6c4XwNJ704iu7l9d3wBwG" +
       "yjPG37wTVvgL9l/x5l2gAikh+yHcamajzMfrQhM2QVZDWE34A1grXTGXMHgg" +
       "RE7z+qQdKrieu1LfWddD4wI+0ilef+reWfe5dghSzeO9P/Oj8t9Z1X6zfZF0" +
       "Z92NDGywttHd3p1lNsXZxR5otHkGbHfOh+IXUFQnN8nMOuGOswBpmeQw9F7J" +
       "mM/N4TVJYpKX+RFkO03y/BRNsiLJl2ePM0Qz74PG+GEGmUdTh0wcGm/my2jL" +
       "a/fjIWGHS/VItZz3buVH5Q+Zm/xma5MUMg8jA7stfDzshczDzRhjVO7tfJqO" +
       "fsrlxvipVIyxTdhoiTfHLVlTC5cHFg7D+0pHAvUlaxVoKJ6H4pHkoH0GR0bO" +
       "oHjOBdo7ofcGvh4evOR2TgLatX4EBU7QXp8SaGu12suDbFotzxIiYPczwB5M" +
       "HbD3Q+N6voS+vO7tBuwhF/CQ6me8d6EflT9g1/nNVpQUsPuRgTcsdO73AnZ/" +
       "M4BFxT7Ipyn2UywH7FupANYUNcJ1H/J10MLTSxa3kAsVMGo5kByYR80x3vID" +
       "5i+g907ON48bcgcnAeajfgQjncBckBIwJZb5vTxwZkm2/DEC9BgD6MepAxRC" +
       "fvIYX8pVvB7lBugnLqAh1Xbee7QflT9Af+0325ikAD2GDJy20HjMC9BjzQAU" +
       "Ffwkn6bMT8EcoF+nAlCHuBGkHyBvH7tAyjiGHLLwHRTHk4P0rDnG1zgQ3mEv" +
       "bPgH/vBOhtADCkxn3UJ8vpaNiDDlADaUDGbrz9nHa8cDCpTC+dRhA8//ySA+" +
       "0l5eP+eCTZrgUj9SDeC9f+dH5Q+bYr/ZXkgKmx+RAesVP+FHL2zMJijnGqSN" +
       "PQSHBJw3OF6KMY3HvUPxVWNZbJDsRByEY3i8uaV4GntOW6R+JDFGJh7fOIDn" +
       "ZF2K9tFjFZH0QGKAdGpOkdxj/xhyPXhFwuMJ8hYc7P390NmneXSm9bgwOhFr" +
       "KHNqL9PhJ0Hg1Y98z88LsZ/EkXZvyWnRecucd9hbjomfrcmuIC3qYqpq/9am" +
       "7TozEpXrMOlOstkzYXwMm9abqsfMoUBDod/be+x7pHEWA+X/f3k6nkTqw53f" +
       "AIXvm8TYjz7VSGeGDZ2473C/Q/wr481+Xc6i2LNl6oybvhzFvjOaIaniihUw" +
       "aYsKksUOMuQBfsWid7OjJcbKnDLw+7ZPZPc1fwEBisRPhlji5RbG9kUcz6tA" +
       "jh+kqpGWkJX3HlyTdyu+PJut6LOjMd2An4bKlhJf2YERN7BX69l3vtNKzW9N" +
       "2b40bxvW/oJSYPFDMyuyfpxnfrXBVz94RuT+HxYeynP+SwAA");
    
    public Main() { super(); }
    
    public void jif$invokeDefConstructor() { this.scheduler$Main$(); }
    
    private void jif$init() {  }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1502340092000L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAL17a8w8WVrX+5+dndkbOzuD3JbdZViGDUvBVFVXd1W1K2pX" +
       "V9elu6q6rt1dtS6zdb/f7wWrYBQ2kKwEBoQo6IclUbJCYkI0MSR8UUGIiYR4" +
       "iVHQmHgBEjFRv6hY3e//Nv+ZHeIX36TOOX3Oc04957md5/T766/8wd176+ru" +
       "1SJPRj/Jm9ebsXDr10Wzql1nm5h1rc4db9g/CYBv/tXv/cjffc/dS8bdS2Gm" +
       "NGYT2ts8a9yhMe4+lLqp5Vb1xnFcx7h7OXNdR3Gr0EzCaSbMM+PulTr0M7Np" +
       "K7eW3TpPuivhK3VbuNXtnY86ubsP2XlWN1VrN3lVN3cf4SKzM8G2CROQC+vm" +
       "M9zdC17oJk5d3v35uwfc3Xu9xPRnwq/nHu0CvK0IUtf+mfwD4cxm5Zm2+2jK" +
       "83GYOc3dtzw74/GOXzvMBPPUF1O3CfLHr3o+M+eOu1fuWUrMzAeVpgozfyZ9" +
       "b97Ob2nuPvpVF52J3leYdmz67hvN3Tc+SyfeD81U77+J5Tqlufu6Z8luKw3V" +
       "3Uef0dlT2voD4U996fsyJnvuxrPj2smV//fOkz7xzCTZ9dzKzWz3fuKHvpP7" +
       "KfPrf+WLz93dzcRf9wzxPc3f+/4//LPf9Ylf/bV7mm9+B5qjFbl284b9ZevD" +
       "/+xj20+v33Nl431FXodXU3jLzm9aFR+OfGYoZlv8+scrXgdffzT4q/I/0n/g" +
       "F9zfe+7uA+zdC3aetOlsVS/beVqEiVvRbuZWZuM67N373czZ3sbZuxfnNhdm" +
       "7n3v0fNqt2Hvnk9uXS/kt8+ziLx5iauInp/bYeblj9qF2QS39lDc3d29OD93" +
       "L8/PB+fn9x/W/765+zwY5KkL1k3ruFlTg/USWa2h5RJsArcOa9A2a/eN62jo" +
       "Xj8kMydm9UZtB67TzqyD9q35RhR6YF3Z4JMB3gyz1+fu4v/DO4brPr+mf/Bg" +
       "VsHHng0Hyew7TJ44bvWG/WZL7P7wF9/4jeceO8RDCTV3H3687OvXZe8ePLgt" +
       "9yeu3nKvzVkX8ezjsxt/6NPK5/af/+In3zObUdE/P0vySvras0b9JBSwc8uc" +
       "LfUN+6Uf/k//45d+6gv5E/Nu7l57m9e9febVaz757Naq3J5Zrtwny3/nq+Yv" +
       "v/ErX3jtuasJvH8ORs28l6tnf+LZd7zFez7zKBJdxfEcd/dBL69SM7kOPQof" +
       "H2iCKu+f9Nxk/sFb+8N/NP89mJ//c32uhnbtuNZzuNk+NPJXH1t5Udzr6yrd" +
       "Z3Z0i3rfoxQ/+y//6X9Gnrty8ihAvvRUJFXc5jNPOeV1sQ/d3O/lJ8pSK9ed" +
       "6f7NT4s/8ZN/8MOfvWlqpvi2d3rha9fyyqc585dXf/nXyn/1O//2y7/93BPt" +
       "NncvFK2VhPaN84/NC33qyatmf03mmDFzUr+mZWnuhF5oWol7tZT/9dK3w7/8" +
       "+1/6yL26k7nnXnjV3Xf98Qs86f8m4u4HfuN7/+cnbss8sK/nxRNxPCG7D0Jf" +
       "+2TlTVWZ45WP4Qd/6+M/84/Nn53D2RxC6nByb1Hh7ra9u9uugJsuP3Urv/OZ" +
       "se++Ft883Ma+7tb/fP32gExdT7YntmiAX/nrH93+6d+7Mf3EFq9rfHR4u6Oe" +
       "zKfcZPEL6X9/7pMv/MPn7l407j5yO1TNrDmZSXvVqjEfi/X2YSd39zVvGX/r" +
       "EXcfzz/z2Nc+9qwfPPXaZ73gSYCY21fqa/vFpw1/FsTXXoWEz89Ls538wMP6" +
       "s9fRjxTX8uXhwd2tgdymfOJWfuu1eO0myOeauxeLKuxmz5itrL7lJsPj1W8q" +
       "eOXhqsbDmntq9fmQTV23mY/xzWyeLpFbm6aZA+hthVeau5efCmv3dPe+dy3B" +
       "mzEPD2bzfi/y+vJ15Pr5e96Zzfdcm99+LfCZ2gszM7n3hebuG6LEfu2Rm5/m" +
       "TGq2xNfmqPyIhY/c7PGqjdfvE4534GC2pg8/IePyOSv50f/wY7/5V77td2br" +
       "2d+9t7tqdjaap9YS2mva9kNf+cmPf/DN3/3Rm7POsvncP6l+7PPXVXfX4s/M" +
       "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" +
       "NO4tGVdc1OnyMt8KNL3qNAurNa6eGEPF");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "CzwlGQNsMgAA");
}
