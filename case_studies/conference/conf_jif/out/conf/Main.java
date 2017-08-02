package conf;

import java.io.PrintStream;
import jif.runtime.Runtime;

public class Main {
    private static ConferenceSystem conferenceSystem;
    private static Paper[] papers;
    
    public static final void main(final String[] args) throws SecurityException,
        IllegalArgumentException {
        final jif.lang.Principal p = Runtime.user(null);
        {
            try {
                PrintStream out1 = null;
                try { Runtime runtime = Runtime.getRuntime(p);
                      out1 = runtime == null ? null : runtime.stdout(jif.lang.LabelUtil.
                                                                       singleton(
                                                                         ).noComponents(
                                                                             ));
                }
                catch (final SecurityException e) {  }
                PrintStream out2 = out1;
                PrintStream out = out2;
                if (out == null) throw new IllegalArgumentException("Out is null :(");
                out.println("Conference system" + "\n-----------------\n");
                out.println("Initialising system...");
                Main.setupDummyData();
                Paper[] retrievedPapers = new Paper[2];
                try { retrievedPapers = Main.conferenceSystem.getSubmissions(); }
                catch (final NullPointerException ex) {  }
                out.println("Performing session allocations [secret]");
                Main.conferenceSystem.performAllocations();
                out.println();
                out.println(("Allocations completed [secret]: attempting to retrieve sessi" +
                             "on numbers:"));
                Main.printAllocations(out);
                out.println();
                out.println();
                Main.conferenceSystem.setAllocationsVisible();
                out.println(("Allocations made public: attempting to retrieve session numb" +
                             "ers:"));
                Main.printAllocations(out);
                out.println(); }
            catch (NullPointerException exc$0) { throw new Error(exc$0); } } }
    
    private static void setupDummyData() { Main.conferenceSystem = new ConferenceSystem(
                                                                     jif.principals.Organiser.
                                                                       getInstance(
                                                                         )).conf$ConferenceSystem$(
                                                                              );
                                           Author alice = new Author().conf$Author$(
                                                                         "Alice");
                                           Author bob = new Author().conf$Author$(
                                                                       "Bob");
                                           Author charles = new Author().conf$Author$(
                                                                           "Charles");
                                           Author dennis = new Author().conf$Author$(
                                                                          "Dennis");
                                           Author eve = new Author().conf$Author$(
                                                                       "Eve");
                                           Author[] allAuthors = { alice, bob, charles,
                                           dennis, eve };
                                           Author[] authorsABC = { alice, bob, charles };
                                           Author[] authorsDE = { dennis, eve };
                                           Main.papers = (new Paper[3]);
                                           try { Main.papers[0] = new Paper(jif.lang.LabelUtil.
                                                                              singleton(
                                                                                ).
                                                                              toLabel(
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  readerPolicy(
                                                                                    jif.principals.Organiser.
                                                                                      getInstance(
                                                                                        ),
                                                                                    jif.lang.PrincipalUtil.
                                                                                      bottomPrincipal(
                                                                                        )),
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  topInteg(
                                                                                    ))).
                                                                    conf$Paper$(
                                                                      "A Paper We Did Together",
                                                                      "We all did it :3",
                                                                      allAuthors);
                                                 Main.papers[1] = new Paper(jif.lang.LabelUtil.
                                                                              singleton(
                                                                                ).
                                                                              toLabel(
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  readerPolicy(
                                                                                    jif.principals.Organiser.
                                                                                      getInstance(
                                                                                        ),
                                                                                    jif.lang.PrincipalUtil.
                                                                                      bottomPrincipal(
                                                                                        )),
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  topInteg(
                                                                                    ))).
                                                                    conf$Paper$(
                                                                      "An Excellent Paper",
                                                                      "Truly excellent",
                                                                      authorsABC);
                                                 Main.papers[2] = new Paper(jif.lang.LabelUtil.
                                                                              singleton(
                                                                                ).
                                                                              toLabel(
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  readerPolicy(
                                                                                    jif.principals.Organiser.
                                                                                      getInstance(
                                                                                        ),
                                                                                    jif.lang.PrincipalUtil.
                                                                                      bottomPrincipal(
                                                                                        )),
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  topInteg(
                                                                                    ))).
                                                                    conf$Paper$(
                                                                      "A Terrible Paper",
                                                                      "This paper is bad",
                                                                      authorsDE);
                                                 Main.conferenceSystem.handleSubmission(
                                                                         Main.papers[0]);
                                                 Main.conferenceSystem.handleSubmission(
                                                                         Main.papers[1]);
                                                 Main.conferenceSystem.handleSubmission(
                                                                         Main.papers[2]);
                                           }
                                           catch (final ArrayIndexOutOfBoundsException ex) {
                                                }
                                           catch (final NullPointerException ex) {
                                                } }
    
    private static void printAllocations(final PrintStream out) { try { for (int i =
                                                                               0;
                                                                             i <
                                                                               Main.
                                                                                 papers.
                                                                                 length;
                                                                             ++i) {
                                                                            Paper curPaper =
                                                                              Main.
                                                                                papers[i];
                                                                            int sessionNumber =
                                                                              Main.
                                                                                conferenceSystem.
                                                                              getSessionNumber(
                                                                                curPaper);
                                                                            out.
                                                                              println(
                                                                                "Session number for \"" +
                                                                                curPaper.
                                                                                  getTitle(
                                                                                    ) +
                                                                                "\": " +
                                                                                sessionNumber);
                                                                        } }
                                                                  catch (final ArrayIndexOutOfBoundsException ex) {
                                                                       }
                                                                  catch (final NullPointerException ex) {
                                                                       } }
    
    public Main conf$Main$() { this.jif$init();
                               {  }
                               return this; }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1501637906413L;
    public static final String jlc$ClassType$jif = ("H4sIAAAAAAAAAO08eXwVRZr9+uUgAeQSCKePEBEQEgFBNHhADq5AMiTxiMHQ" +
                                                    "6ddJGvu9brr7hQeI16rghSsDHj8FdURHWQaccVxdr1GcGXAc8Rh3PMZr0R1P" +
                                                    "XHRG1HXUre+ren1Ud5KX3+L+tfn9UtWvuuqrr767vqr3dh0Sci1TGLNSbSu1" +
                                                    "1xiKVbpIbauTTEuJ1+namgbS1CJ/c9cf47ecZ7wjCnlNQh/VakxaUptSIxRI" +
                                                    "KbtDN1V7jS0MrFkpdUplKVvVympUyy6vEfrKetKyTUlN2tYq4WIhUiMMVEmL" +
                                                    "lLRVyVbi1aaesIVxNQaZqF3T7TIlbZcZkiklyhCVsroKTbIsAikPWzNA+him" +
                                                    "3qnGFdMWjqshiLPemtSqaGV17F0NfCpPm0IsA56tjy4OIdPVbT2xbMvNFwz8" +
                                                    "VVQY0CQMUJP1tmSrcoWetAk+TUK/hJJoVUxrbjyuxJuEQUlFidcrpipp6lrS" +
                                                    "UU82CYMttT0p2SlTsZYplq51QsfBVsogKMKcmcYaoR8lSUq2dTOznLw2VdHi" +
                                                    "mU+5bZrUbtnCMJcsdHnV0E5oUUjIqZhtkqxkhuRcqCbjQAtuhLPGksWkAxma" +
                                                    "n1AIv5ypcpISaRAGU85pUrK9rN421WQ76Zqrp2wg8MgugZYDIyT5QqldabGF" +
                                                    "Ir5fHX1FehUgIWCILQzluyEkwqWRHJc8/Dm0dM6mdckFSRFxjiuyBvj3IYPG" +
                                                    "coOWKW2KqSRlhQ7sN7nmJmnYExtFQSCdh3KdaZ+HL/r8rCljn9pP+4wK6VPb" +
                                                    "ulKR7RZ5R+sxL42umHRqlIqgbqnAfN/KUfjr2JvytEEUa5gDEV6WZl4+tez3" +
                                                    "5126U/lEFAoXCnmyrqUSRI4GyXrCUDXFnK8kFRNUZKFQoCTjFfh+oZBPnmvU" +
                                                    "pEJba9vaLMVeKORo2JSn42dCojYCAkiUT57VZJueeTYkuwOf04YgCPnkXxhE" +
                                                    "/vPI/wWsbrCFhsrTmhstxawmUKzmSl1OJRSiwM2NSbXZ7lAs1WqWJUtpsexU" +
                                                    "XCU9iEQzquNjC1HIZsuU8UPzEqL8paTF+JHgpmE9A1dHIoTUo3lF14iOLNA1" +
                                                    "Ygxa5C2peVWf7255TnQEn1HCFgoAYilAFCIRhHQsKARlGCH3hURxiUHrN6l+" +
                                                    "+aIVG4ujRFKM1TmEWNC12Gc4K1ztXoiGTiYi9qczjRWbZo6aIwq5TcQAWpVK" +
                                                    "m5TS7LqKeXoqSQzFsU7TMoXYkCRarlDrmW/IOMYWhgfsHrV3ZJjpAoFho4hY" +
                                                    "l/DKFYbmgA0fHtlz03rdVTNbKAlof3AkaG8xT3pTl5U4sYcu+Mkx6aGWJ9aX" +
                                                    "iEJODZLcJisDCzOWn8OnxeUZiwhrySXLa9PNhKTBqwxVCu0OU1/ttqBMHAPF" +
                                                    "YCoewFEOQTSmp9cb21478NEMURBduzvA48fqFbvco+sAbABq9SBXQBpMRSH9" +
                                                    "3rql7qdbD204H6WD9BgfNmEJlBVEx4k3IxS8cv+q1995e8croitRNnF1qVZN" +
                                                    "ldO4lkE/kL8I+f8e/kFhoQFqYrYrmLGIOdbCFvTag1dtPu1oalqF87J+jWUr" +
                                                    "CdC606ZNnz1l+klTp58MS53gEoMYKo0YS0Irq6QxmdDjapsqtWoK6M8/Bhw/" +
                                                    "7aFPNw2k8qWRFsotU5jSMwC3fcQ84dLnLvhqLIKJyOAoXYa53aj1HeJCnmua" +
                                                    "0hrAI33Zy2Nu3SdtI3ac2E5LXaugORSQAQJKzDQk/hQsT+LezYAiRswE/5JM" +
                                                    "N8o1BqiUJNZQaSDSIg/7orjMqK58F4WtEEhL4itVJpHT6IAuVzhvQaHB37dn" +
                                                    "Oo8JdF7ovgZVHM7jwObPWR6LfxErPh/1r29csWRTNTJSTbxDoaUmDI2QW4mj" +
                                                    "2SBxia0vIuRzgixTSloaETNqahrwZVXaMMHFd0om8gmpUpwGDXHQqIPYrUU+" +
                                                    "5doNpj7+mlkiI+QxVMIJ6RYJrAAPdHOmhrdDDCiPTZPwMk5NZMyQY1rGtpWD" +
                                                    "ouFEGdxcirv4tcjbht78+OB/2TyXOvnj/CMCveecVHFVy8m/fB7VEqRoLE/S" +
                                                    "ZYpEnAqleYv8xfY3lGUzv/mMmhF9dZIPTA0SU8mqIUFwyp4gpjURCqxjHsGq" +
                                                    "KCA7DPys6+/cc+jturNQ4D1cgsgjEPwyMXAs4Bx8rPI7Kgef0gbdcFBqkS8Y" +
                                                    "9uKJox8/72ovmbgBnt6b7r89/7+mfHMnLtuRlfGcrDgDupUXKE+j+KJB8THI" +
                                                    "i6SXT8OHvvXK/s4Fn1F0eTkIG3Hm9GOf/LBoxDrGWZiwms0K1aJQZp9D9jcu" +
                                                    "s2OlNXt/k7/sDx5mIwcJCVZjR8pPKCtcBtQRwMeH0XOebtt6wkPV08e/sbL8" +
                                                    "u5d+ndGS+Q5VJvkXyI30LjNv8mMjNv3l0toMjMV0qT/xLLWeNs000qhh5+Cn" +
                                                    "MywwH1zos0CyOoh/e017tWnrW5PHUmJ7/B97/2jllVtveuThk2l01I8o8MAz" +
                                                    "zxIEahkB+FwDcWmmqBg+NLiPtbSrRBlkOMzxf6R1EVpfEcI/XyRWDXsqN/qQ" +
                                                    "157+183fryLRR7RJOKZDshYmiUuHLRzZKYKJdT7ZwiCPWqHtghhE88ZT/L6D" +
                                                    "m6ypbNftIyvO+AQ11g11YPRx6WCcerbkicKm70x8KRbn/U4U8kmwiCEg2S6f" +
                                                    "LWkpiDKayO7PqmCNNUJ/33v/To5uW8qdUG40H2Z5puWDLDc+Js/QG54LOas9" +
                                                    "BHgLLO5D/t9k9R6v1Y4I+ED37eOwLIHiBMozm8SzpkqMBsE8z8JNd9qBjj51" +
                                                    "MIO6m9V3eqDbSB1faGL5vB/adSVOt3n33Ldrd3m/++9BtS1AZhLW2szT9YER" +
                                                    "mc90nf0dTHCfNIb8F5D/P7H6CVtY8WNHWcb/wRyU4DOhSFJTsJaZAijPC1Vk" +
                                                    "2hnK9a5dSfoVOthU6w67PMthfFqqPtVq2Z7EwLkTz376ihHWtdQmTXLUSknb" +
                                                    "pZgwYkP5ca+/Fp3e1y65AYUhp5UQEBMKRAks6GkLsa5TUgiLOti+UKzGx2sQ" +
                                                    "5aG2MBT3kjylcUsZWEmLPOjU21rbLj9rHxqKATg5Sm09RWOCxxC5g0rq/f38" +
                                                    "Oa7QtbfIH+65fv+4j88egsmLzDK9W50lklHOb23AtJP23Pw3nn5m2IqXooJY" +
                                                    "LRRquhSvlnADKBSQnZdidZAtdtpgQhJZDYoqst3xCC4KdO3crGd3Rl84u3kb" +
                                                    "VUjPdrDIv2hvuonlucby9jkDlaa5kCErHfUdC1hNYmr7DqtfgbdU3tekBWqm" +
                                                    "bg43U1F4nAgFQS63TU1KGs4wyRYitVbQFxCPnCDOpJPloJSNW675oXTTFtGT" +
                                                    "qBsfyJV5x3hW0R8nAuc/rrtZcET1B3vWP3bf+g1UGQb7005VyVTiF3/+7o+l" +
                                                    "t7z7bFgGxAlIoOlavzMNkrj4vfwNCz9cdA8604HgkDCcS1KhxKaFSX9TX9Vy" +
                                                    "QhVc2l1Q3E2l5ISwyKgqTYIpQmxPbLT23aEjSg41DeFXgHGSAWQ60R8jBWB4" +
                                                    "o6TDo9UHXn/28HdOlBRq8ghxas12KakSK5yGKUrCFJnXyWnl8tK9+qmTENM8" +
                                                    "u0O1Sk7CnWqIPpdTObwRUxWCxwa3B11tISFYjNbC30Jc7Z4uXC08rkIZDvGw" +
                                                    "AOwLVr/v87B5hmQopoVDUn5sZjNsisKwoU7FGTA5ZECk0DsAq4d79DwOxBOh" +
                                                    "8RQGaTir+3ohQvkY9r+XRYr3GV5eUn/jAJwVBnBYYE1eX/YIzvGM67geCfqy" +
                                                    "Rzy+bKQrOBjBYUKCGol9M4q2bvjpV8OJMWwS8lmEh7HeUj2JH0Iy5J7xh3e9" +
                                                    "88nL/cfsxr2949AK+aOF4MmB70AA19PPz+bJGW51yeYUFM/xLM/PCBds5Vew" +
                                                    "utEWGo9mQFMH0skipR8HMFH/okziQQJ6x4C4bgLi+ayCpQNI2VdcsTgQlJQD" +
                                                    "QQGjw17vxbAN7rC3MxEJpppKcUXYdD2Wm0PcNbRv8bO/hHHOZLUEb19A9r+Y" +
                                                    "8Zvv9eg3obgt4zT7zsUzQ7SVOGYbc3JQ3Wl7dlrvYNMOKD4WIgInYSMAvxOY" +
                                                    "eOYz8fwmYFQ+zd6ojITGCQxiHoP437xROZy9UTk+BGAkt1ujcgjn+Npl8KEg" +
                                                    "z52mNH3YBcV/OPnICDubgM/tVDmZd/ihG+8w0cekPE1JttsdPgUPSW82EMfG" +
                                                    "0os3HTl22eXnfN2I8Zwo407qOLKzaktp2lKfp55N4dlCJQKJ6W0xoqAxy1Bk" +
                                                    "sgWPZTJDsWJwm8UxNRlD4T1/nUPmg1dtPnjNPeuXr1t//nLDyaw4Xr9CSiZ1" +
                                                    "O5DWy5PVhw6VtTn+/kxK0v0e+8WWipqNSgTF9xbkwkIz1FUJw8ac8tpHhv96" +
                                                    "zs+3v42JpQAn+H3MEjS6bix8yl2VJaP3rtp09A6I4OOo8LOg4zg3wiNz/5Jd" +
                                                    "z86fIG8mwZ2TOwicLPsHlfszBoV01gZf3mCsQ9pIATyOR5RDU+yRId28GwrF" +
                                                    "IGImZE1PKl4OwotCwzAiEUEIDPVmuyIjerQJmICKjO4+AeXJVUWoUnWZ1oLy" +
                                                    "nDQc74zuTpjD7GGUsBephjocycXp+kHRX4hAHxYzPkxHjIPieMcE4V8e+69n" +
                                                    "9RKPCcKeRe4RxpiuzuEx8t9x+Zbt8dp7pmV06C5i/WzdmKopncyaU1BReI64" +
                                                    "uSII+oRx5J8QO1LF6jm8aR2YpSfxh7DDGbhyVk/kV+cKksiShajrDpT+AsOQ" +
                                                    "PEQeZ/UvfWbaF71R2zfXbGem777+v3vuUFH1foy+RFmFQ5rAsWlc6UpbUgYR" +
                                                    "CK/Wip0qPNF90mwHzWFhaD7qRdMWFsO8Cd00OlR2TALmlR6ZkgCmHYOimAGN" +
                                                    "NPKLJYj5iE1shemVeExq1TuVWOua2Lr1k1CGI/m0gsOEyHTKJXic0R1locOp" +
                                                    "yKUIJPUjp6PMnoHye2bv4AWzpY3JC5P66iQNfOv77kr90xNTX8vII9swA8SF" +
                                                    "WM4Ph4sd3F6LoZhmCzlADWwOMyEhZwMMGSYIx5Z9uq3264MPZLCZTRdp+Ci5" +
                                                    "lGu0hYjBhTY9cxpJ2ZBN8BlpxBWe64QPpIGPKLimWnfY8iyH8dn3Gl2WNNen" +
                                                    "NFy379VZt364GbfD3afSuZHaDm1fzd/XHMiQdKVfa0cy4jwZprU06onEw61K" +
                                                    "ZJU34GE8YKKL1IXPdwSEGIqVKMihdIc3Z0HRkYERiTuAPDZndCa6Bqz3s/op" +
                                                    "n81xZk4QxW7ISrHJg5WFbh+8ZgfxOq6GQ1lFpB+Gc6KIeE5i+D0fhqctDHJ3" +
                                                    "SO2xVmbIImZW0mkhxVZTz0obfM422FTrDrvIFUUrKJ2+pkgrbWIycVk2MuHS" +
                                                    "Yz9lgysiCX6/i9IIW5ICAuUEVo8i7t5S26eSfWUZf8WObVtnl3XoCaVspRIv" +
                                                    "W62bF5ZBgihOAkp86G4sIvkS4LIhK0JvRIpd75JnY5BiG4NmgA7b3IthZMs5" +
                                                    "EKNlQLiUIkyiMrohyQg0lHAtLXIrFIbhqM0VKDoui0Ioj2uG4mYEi5/nZeXo" +
                                                    "MSkxljFnCqsJvhW9ZIIip+DOa1VaVvAGBePl0QDDy9VUQPkaKmBiKdO/l7z6" +
                                                    "x86xzzBcXt+NNLnH5dDdQabd7bHd43i3tkRRbM+1khb5rr7qTU88+cINNLk8" +
                                                    "Oqx/puu9g0fcu3ni3hrcCPbpkKwOCH5sYYjnbBJhK3AR4JgEGQoXmUgwz7Yx" +
                                                    "9DZAhUMCWLVwNSPBVEaCl70kgPX8gm4Ee7xIVK/Yl47Z/NINt13amPEpU0NU" +
                                                    "J5+qgB+JWWzyN7pC4lfY35sbyJ1LqEK3KdUOsJlhwF7njb9j8Jxxc2DcPNb/" +
                                                    "r6x+l0fi0QAS0Xl6K4fC3DBQ/9kzCgtg3DLW/wirP+VR2BtAIb+iQzI1xeLQ" +
                                                    "+EkYuC97RuNcGCcxmchl4/7Bo/GHABp5lUqS7Lo4LFaEQBNzesaiHcYlWH/m" +
                                                    "BUQ+Cx15OciPqk5eJLQwUAN7RsGCcZew/uNZPZxH4Y0AClzOykXk4jCAxT0j" +
                                                    "cmWIloqTeEQOOrd7uNOeyjVkS6TKnsOexu8Wjfrm0OK99LAHri6H3ZSbKxPt" +
                                                    "surIW3piNt+P0FUMkclhCBFcJvszRzwW3vTRda11Dy558/uU51KN744U2xU6" +
                                                    "+GAgO23hyFPmNP3rXjwpK0iSXbK5NKVpZI+nqSE3X33Br2+fmA7ZfLhzLdN1" +
                                                    "e+aN2u4HZ37UTE10cLvqdNZzTi2f/9iCCaLvHjvMMoDuKz4QoIw7QbErHBvD" +
                                                    "mDwlRDjSmVBglCcU4P1dmHc+nnnlGa53XtQ7t7qQ2P12SZvLYmLeSR9FaO7d" +
                                                    "CeJNHTfsuN7ITih2o9x/S4PQPWGeBh0HGm40nWi40G64mouh2HsI6XsE9D7y" +
                                                    "ie4RPqSwP+ZYBw+HHT4Uu3zoakkIHpJPkWlQ1OBQLhmV06mrcc/e2N2mewQO" +
                                                    "EvwVTmqyRa758t+HdU7Uf08vMDo6j0Ai3KUiODISyO5bGEDA/hurLw9ImBvp" +
                                                    "5SEGeX4DFxoL+5xxT10dl9lTR59j66mz1/30iEHGSfTU0XM+TTqI/f2b8QqJ" +
                                                    "sNv0sqN43Iqq/bVn7M+GHYthjgbGht+y+rFu2OE5fIi874ABD4/ZRxj+DKv3" +
                                                    "8mC8kixOcSUZlzWZj4whm4jeCnJ+P2N1lRdmMDIWpyGsGU4YTBr4yNjfFNnp" +
                                                    "TFgME65nE93F6mrOw4mzu9F0zmUiwMkM0NKuAM7JLqacFAbMm+jtwm9jhmsW" +
                                                    "69/E6gYeicpsYsqZYaDO6xkFDGurWf+VrF7Bo1CTbUxZFQZO7RmNGhjXyPqv" +
                                                    "YbXBo9GQZUzZEAYt3TMW58M4ifW/ktWX8Fg0ZxNTrggDdUXPKGBYa7H+N7P6" +
                                                    "Wh6FePYxpRkG8KaeEVkTpnHbeEQ0ztjgqLWs9/awUQFjo3cZ8VwUhsKdIahn" +
                                                    "HwyI6aMVDIjrehcM2IJonLAqLC+5ysmy+DI0OI5lZ4jdgXwYju99guYUzk8E" +
                                                    "zgvu8BMQVnc1JWKo2wsl7HXO9UUa6NAsw+CDd+746rINs0X4vk9uJ9yUJgGy" +
                                                    "J0e1NAXf771q19Yxfbe8i5dJjdyRn4w6WkzanB2TGGsO49L+5hLmSJAwt/SW" +
                                                    "MLdBg3j90VzVHb1flRjFEkWDhpjwMTcknIR2OCUW+3YR7sE7OEISB0MB97TE" +
                                                    "kVDAKbOICSTx5whlAhQTu41SoMcUtoRQkoYEJWRZOMlOlzkkbkDmPNA9c2jw" +
                                                    "gcwR8aBBfDBL5ohwXipWQoGEAyUWm1c5phiYI6L2iQ+7K9O7sXaUOaIVlLDH" +
                                                    "eythvzn6EvZMLyUM33FfT4DLNyQ2HLmC1b6ACMoujpy7vzAJkGpYfYYHIidl" +
                                                    "nmsL4oFu3r0IxX6bhN2KnTIqU4nEmkrJlqhyuN8z9AitWOAgdTqAWcaQuY7V" +
                                                    "q73L7Fr2e7u1+DMfgwN5hZPZpMkMrb2TozT9pRtpwkb3DhYcnQgzGKQEqyWO" +
                                                    "a+I7PcUe7h2s6WEAtQB9PGce4ps4xwcUEG3w9vE3QXlOmOhNJP9PC8JxJquX" +
                                                    "HxXRA0jNrF7ateh5mexmWOB+KwamMHo7qy/jaRE5zRlQHTbgn70DbKEjq5NJ" +
                                                    "PWV7DiZh02nP1TRdxh/QsMIOKfkLMsH7COIh5/6A+Fl3BIAOf3ejG/EIMvgr" +
                                                    "lM2vewUPuuKVgajQtUJHgYXip7YwkF8nDu/idhJeDCAoBG8LeBtJoE9I6Tqd" +
                                                    "I6hh0cLsNWw+NNYzXm5j9Y2ccEb7Z69hy8IA3t6thiEDokNddToS1DBfU6TV" +
                                                    "L8Tnsml+FibE9Iw3OjJcv/xnvA41mZC4xNzgzIiJSbiOAQnJCYKTmCzPOpWo" +
                                                    "6vg9WLveNhUp892u/81wxDOGGBJE6LfcVb3U0wvfZXvXF+/SxtjKSlkNbjVa" +
                                                    "jKQcz+76RieG0zTq/GyB800+57sydJLe/Y6BAbdi3ARktAzZ9RE84qyfcH6o" +
                                                    "AiBVMVm4gdXXe2UCsZ/Ro5ZAr5ORuKc4kkgaeOHkmmrdYXOyG+a5uRudEDBM" +
                                                    "0DoPjVOXUSRcdI6ORWlFWUd5wDffdmOYqtAwwRPcqfNFF/6Lkg5lwYthTgco" +
                                                    "emnGpQUoOz97+4OJqpkM0iWstnj7szh7+3NyGMCLu7M/0QU4R73LmAVBXi3w" +
                                                    "eXhbyCGW4oQwgn/RDcGbeiY4kg/nIM40B36FBg6WigI/WkV/aEnevX1An+Hb" +
                                                    "G1+lX/XI/BhSAbtp7f3eruc5zzCVNhWVqIBmeDGpGr2AzAhfD4DnlrDrG/RL" +
                                                    "xGnqsYr+P9XuxsPdMP0i//eQ4cJ3iv6S");
    public static final String jlc$ClassType$jif$1 = ("WYt8ePq0yif3T9jHfrOgy69tuiP2bF+0dN3ns+g3l3NlTVq7FibtUyPk0yAL" +
                                                      "cYCfURnXJbQMrLwFk7495oGC452f4IBisCcaLfJaAc+t4MA5p+9X1lrkC4X1" +
                                                      "1/52w+DL8AtMBarVYKYsG37vrEDO3B8GiFvptUh6DTt6hfPVP8+vNnjAek9f" +
                                                      "Iytvra3J/+Fc5/J+KIfofej/AX/AcX/TTgAA");
    
    public Main() { super(); }
    
    public void jif$invokeDefConstructor() { this.conf$Main$(); }
    
    private void jif$init() {  }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1501637906413L;
    public static final String jlc$ClassType$jl = ("H4sIAAAAAAAAAM17a+z02HnX7Gazm6S5l7ZpmjTbZJsmdbq2x/bYk5SqHtvj" +
                                                   "8f0y9njG3WTj2/h+t8eeKUGAoK1aKaCSXpBoKagVUNIEVRQkoCh8KG2VCokK" +
                                                   "QZGAVlUlQCUSBQFfgOKZ//+97LubbT+0iJF8zhmfc55znuf8nsuRHn/+K7M3" +
                                                   "ts3s+arMzmFWdi925ypoX1Sdpg18KnPa1phevOz9CAB+7sc+9c6ff8PsHfbs" +
                                                   "HXGx7Zwu9qiy6IKxs2dvzYPcDZqW9P3At2fvKoLA3wZN7GTxZRpYFvbs3W0c" +
                                                   "Fk7XN0GrB22Zna4D3932VdDc1nzwUpy91SuLtmt6ryubtpu9U0yckwP2XZyB" +
                                                   "Ytx2nxBnzx7jIPPbevanZ0+JszceMyecBn69+IAL8EYRXF/fT8PfEk/bbI6O" +
                                                   "FzyY8kwaF343+8CTMx5y/IIwDZimPpcHXVQ+XOqZwplezN59t6XMKUJw2zVx" +
                                                   "EU5D31j20yrd7L1fleg06E2V46VOGLzczd7z5Dj1rmsa9eabWK5TutnXPTns" +
                                                   "RmlsZu994sweO62vyN/52e8tNsXTtz37gZdd9//GadI3PzFJD45BExRecDfx" +
                                                   "rd8u/qjz9b/4A0/PZtPgr3ti8N2Yf/Cnfu+7P/bNX/qVuzHf9BpjFDcJvO5l" +
                                                   "76fdt/+L91EfXb7huo03VWUbX6HwCs5vp6re93xirCYsfv1DitfOFx90fkn/" +
                                                   "Z4c/87PB7z49ews3e9Yrsz6fUPUur8yrOAsaNiiCxukCn5u9OSh86tbPzZ6b" +
                                                   "2mJcBHdvleOxDTpu9kx2e/Vsefs/ieg4kbiK6JmpHRfH8kG7crro1h6r2Wz2" +
                                                   "3PTM3jU9z07Pp+5ro5sZ9MdfMtugWU9U2pfo0uvzoOjal8wifqmLgjZuX/Kc" +
                                                   "Nni57Xo/nkZM+L6X+q35chIfX2ob7/bnJcmJixenN9UfE93xys/bhqeemkT9" +
                                                   "vifVPpt0ZFNmftC87H2uXzG/94WXv/z0Q+DfS6KbvflK8cUrxdlTT90o/Ymr" +
                                                   "Qtwd2CTudFLjSVPf+tHtJ/lP/8AH3zAhpRqemYR1HfrCk7h9pO3c1HKm7b/s" +
                                                   "veP7/+P/+OKPfqZ8hOBu9sKrFOvVM6+K8cEnuWpKL/Anw/OI/Lc/7/zCy7/4" +
                                                   "mReevp7ylZtu4uWqvN/85BqvUJBPPDA2V0k8Lc6+5lg2uZNdux5YiLd0UVMO" +
                                                   "j97cxP01t/bbf3/6PTU9/+f6XLF0fXGtJ4tC3eP4+YdA7ma50oROEU8I+O3v" +
                                                   "++Hf/sGf+fgfBx4+DkMfmy++AyGqO2RcD/MJAd7s6J/cVj/xG//8PyFPXxl/" +
                                                   "YHLf8Zht3gbdJx5T8yuxt94U+l2PsGE0QTCN+3c/rv7lH/nK93/PDRjTiA+9" +
                                                   "1oIvXMurWJxJHGXzF36l/je/+e9/+l8+/QhM3ezZqnez2Lvt/H0ToQ8/Wmqy" +
                                                   "ANlkhaadtC+YRV768TF23Cy4AvN/veNb4V/4z5995x26sunN3Vk1s4/9wQQe" +
                                                   "vf/G1ezPfPlT//Obb2Se8q4e6JE4Hg27M2tf+4gy2TTO+bqP8c/++vv/yi87" +
                                                   "PzEZyMkotfEluNmZ2Y292Y2rj92g8223Enii78Vr8U3jre/rbu+fbV9t4tdX" +
                                                   "X/kI+jb4+b/6Xuq7fve26UfQv9J47/hqk7BzHtPK+c/m//3pDz77S0/PnrNn" +
                                                   "77y5aafodk7WX0/VnhxtS92/FGdve0X/K53mnYf4xEPVft+TavfYsk8q3SNT" +
                                                   "NLWvo6/t5x7Xs0kQX3sV0ndPz5um59/e11+89r6zupbvGp+a3RrobcoHbuUH" +
                                                   "r8W33gT5dDd7rmri06SIE8raW7QzPqR+O4J331P9wn39U49R727SuVe+7bnt" +
                                                   "gvw2+d2TP7/ZTuqJ3jvVu5bQq3l4y4T15+/q2X97DR6+66vwcG0S12L5Glu/" +
                                                   "Evuv9/XvvGLrz1bOFH207atDjBtw76KA//L53/zdX3/b+79ws6DPuJPZuR3D" +
                                                   "k7HZq0OvV0RUt1N788PNvfW6uW+bnm+czd7w3rv66d/vZp/+ozR8T4r+3tn+" +
                                                   "sa8xPkDAW24IUG9CfqDWT927xxsCrsX6weGKr3O4H+4m1YgLJ7szgNPRZUER" +
                                                   "dtFrWAG1ifPJLp/uA73gBz73g7//4mc/9/Rj0fCHXhWQPj7nLiK+LfSW22rj" +
                                                   "tMq3vN4qtxnr//DFz/yjv/WZ77+LFt/9ytiOKfr85/7V//61F3/8t371NcKM" +
                                                   "N0zguf5hxodyevqO+QeivDOqV5Myhb9lEVzt84O+u5AkLl98eBGZOsdXSbyZ" +
                                                   "feAJJqQbQB9Zvb8tff5X2Q97P/z07A0PDdarbg6vnPSJV5qptzTBdPEpjFcY" +
                                                   "q2+8O+Ybg9fiW17H0ruv0+dfi09PSPCuEnjA/TsfSebO2I6PmZi783tqcqBv" +
                                                   "RF5EX0Su/6PXxtkbbji7GZFroTxA2jckmffCg6BlNyF5cnQvTCh/jfXvbkiv" +
                                                   "sfwk+7c/GiaW0zXqh37nL/3aX/zQb05g4GdvPF0dx4Sax2jJ/fWe+X2f/5H3" +
                                                   "f83nfuuHbrHAdIif/Kkff8dXrlRvgXsy3cGuu9uWfeMFotN20s15B/7DDWr3" +
                                                   "CL5WUwD/zCS519pg9/xsg7Yc+eCnQESwH3a63SyB3gzJQNtSQqAyK0ZjwvVK" +
                                                   "3kQkXWOkFBtjLG20he/z7Klfuk2DR1rAwYsmjLYtvUmItW/qG0tzPG83+g3M" +
                                                   "euye9Ag9QlTJbiAdVvcbnYU3e7MJgMmOwKaPCXsEEIHuWCzNzjr1fT1RXeCn" +
                                                   "ukH8CNp6MWyworx1tz0Mj7GwcyvOdXrDYHoeBiYshu4WpnjQW3pHFA88Gx8S" +
                                                   "qshkLZp8bTo6ZtVtuVHnBLejZXiHJ1tIatZp5ZtVJuxOu3Nemefz4sQcGyHo" +
                                                   "hLNhZvK8O9SoxUVmLEk7JhczUd+dd24MO07QcrtR1hy7XiMGbnCZa3t2GqfZ" +
                                                   "OaJ2bVMKhsu1ZJyq1kUmgSjOkbpg175kJXUbxaIa5N22dtgdjK8h+UhVag5N" +
                                                   "47FFl5xRhfPVnWvMR1c6yevhQux22gGiNMnkVbjLt41XWkFHpoBhCmDE8+XO" +
                                                   "HBs3Ofcj3zOama1j32uquKoWWbM1TWJOHaSuM6Bqvs2M1j5UWY3BWntc7doy" +
                                                   "FCTBy72DU+pEtjXruW8ol0Ic5jt/E+cmgLl2Y7pdQUm81/qbYgcxWGmaCVfb" +
                                                   "UZfWYxr1uldTbqKRXR+JKpu2VkqOuVPAJHfCzpVXcVtHJ1mTwCqzEZaNjM5h" +
                                                   "S8MXdt1U8yEkpLAP7QPNnQ1MqzPfcdk112DHzR5eB5EZchbFidol689MOtSW" +
                                                   "vuE9AqRzyJcWue+l662+HpO4P69OCcIdVNYrFUuw5kK91bNIw1sZL3I+Lw7M" +
                                                   "2K0nNPsRIviODWxEsCEaKkuKZaUC6CAsdqrbZ4KO6zamA+0oovM+3+h1xtWh" +
                                                   "WxfkUQYF85g0c/507hjGdLCQZnYLy85QoAsuCAbPFyaYMWuy3FNFfm5qc6tz" +
                                                   "KHveN5RJ79eFQKRrXTZtYa2VlJGsjxFQ2iu1yE9mxfCuszw5orQLBEUv5/y2" +
                                                   "QOfTHT85UGQamwaG72y+DwLjkPaDcoTQQ0ipRbofIwY8qRw4WK3bUOvJLxp5" +
                                                   "NIXdzpCbwiXfZrDC69t4kOaT4uxtPCNb2Kot3uyqNhjNPWUuY0a71L2cUPCG" +
                                                   "s9veJEz1wtQiUTnGGuA3YZUzSxL2N1xpmCWSrWE0VkSZhA/h6GDUvAp21hGf" +
                                                   "Y5hRaEwBb6h1WJKHOCPXFKdHG60VSD1jqQ0SmfoYm5tGXmQA4HA7Fu0TfS1I" +
                                                   "sJEzlkzBc9ZDBfjS7cuYNeJDvKy9S6Jbrl0uHG6oMcPTSKvaCTlmbHGxFoJ9" +
                                                   "WW+1y7o1cUMq94eU0p0mo5vcAjlFOlhReGw3zQ6x+aQiy3VUotEhA2lhfXDz" +
                                                   "kISOmy67QEjj7wzZFcisPCJk6rDEaCCVkWEm2h68HpDSceGwFr909jHDK7Qt" +
                                                   "enzc0tRFsQpCKcbAtOMhas7bvegsVTkSjFU9jDuqhxQTBruuXkkbUl0fqDIY" +
                                                   "1oyiGdu8WnruHEZxQmYkU1/5/eVEosSxXrsnrwRa0iVX9XK72murStK3myXS" +
                                                   "1Ble+y49h9DNwqKXq/Ao5wyfrXbMiKYIN24J7wTU8HKJBYTXlHGny8Uarne2" +
                                                   "nPkKmqUMmIoEBxyJAEwnOWjr+tAcmlxkOcV3qfXJcELY79QeLp2sXhM4DySW" +
                                                   "2VA+tYAWtlxc4AxIM6PCCGmLISFTSgehhA5biGvqhTbmPp04VVt3ViksJAJc" +
                                                   "RQOIO2tVHuYpMenrui07E0u20kAhR08jUF8sxFNUi5zAn5VJWQ4OhjgJvAn4" +
                                                   "SW16B4oakkMQ+zyXe2TrdxzieHMGE/dOHyr6ViM1XrjQWgpGWmsAYnA5kLHe" +
                                                   "DgyI8ZJMlPCqjk1etjVnS2+5EMTLJpFqASPWqDWpbSSicbfjq42x4Mh+d4lO" +
                                                   "mrNZIbhfKCXB+2u8PIX2biPhyaC4qqUvxOPINGoEws186bWWbsgGvzXckS4d" +
                                                   "M6e5uWaheTLfrsbYgU5cr1/CeDS2Wekwhlw7UTPYu70jSZu1D5U5EU5OphpY" +
                                                   "er/Rak49NOZkYP1SrhIcyLM05gBt3Ekcv9APfEOSqr9R8qjxaZqKVcNWBynF" +
                                                   "ZFs6awe4YbvKost+zbD+6MXNCe28xI06nACUFTg3znvlVCQgJVGnIPB2m/Xu" +
                                                   "TOTgcYXvmFovRQbcTm6AKcg6Cw4nYjwekIw1Lycwl/JovfRtTjVIaGsSec2Z" +
                                                   "6+FcoWGVmDpVj8mmZWuBInFaPbcLAPQ8IJlCP1lDadgL2zBh1OEs7ckWXY1E" +
                                                   "o3K4EAZHKHR9b72q0y1xWPYCX44EiM/LU+6Gq6JbuHhDLMFJBMeNVIhdr2dH" +
                                                   "1mvokO4rcy8wQAII/IowNly82O4NQtmcTnsBbNF1Aa+hwEg5FtnkS1Y5guKq" +
                                                   "HOmGtSatzFtIgB1es6slvUy8vp0rmbzvwBQHW3rEcm7weGpnJzpRqQLVeatO" +
                                                   "0wcp2EB7JXC7bjGk6m6KhsDWFYke84HCZ7eAhu34U7o/cwgkJvKJyKWpRDKo" +
                                                   "K6VE2kG1AY6iaAVyC0FQHUUYQBXSeRg28KVsIeqslBEYQDDeWUVjYerGzHkc" +
                                                   "XC1xcJ5k2a47Bb0RpfMMgjmiJCTychk5xonSFbAeaM/K83oVArIYq527bfRV" +
                                                   "lirSZTwudJjZVUfG48D9WbfofVvLYK3BGA7ABHJszqI+OTVeEWy6jQ55bPYb" +
                                                   "Ub/YwkHgfQO3h5hSrXrThVHEEIRtgOKCzhfnypWPHXc+KQCpwXAIwwdVHxcW" +
                                                   "5QWNm8aekOPQSAi6W4AmahJpPpFhwvl2cRSttIppwTkruFrnlCybPIggJ9Ao" +
                                                   "sd4iat9kUWgzt7Gqt2iR9gC+BTUWQ0XFaZerTSiKCkaD3TJd6osTfEA5gKER" +
                                                   "PFAGkdvEK6m85MT2UqW1tGoZ4kLwsr+sV0mCwRKnLPLlDglq2t2u4KPDithp" +
                                                   "BTr+dqd0SIEgot/4SA4CwHLVbWHSjkRr3l6M5YHRc28JFUfINzbUUeZcYj1t" +
                                                   "QcU3C2rXHQhL3lieCw762URpJdqueaPlHZuME5WCd+k8KoSlg/nbYzktFJmL" +
                                                   "YYGrUhcd13Wtdrt6buPMIKbGBcEXcbSxOl/Ljb1obtPCrexwOKQq5jkAuK6Q" +
                                                   "AD4vMPJgRhVmasxKEnQybRdsKrYOZphhLCpdDEx+nR3nrYY57FxaGUianDPP" +
                                                   "bG1rik9VJTHncOOKybLZjLVAGiG2zaGlbinUOFJYCDU1eEQIxcG1zj1yG2CB" +
                                                   "HU8AmhBEELa5eKGFpYVBWZptFHeOkB2vzhF1QIoCy+dcvS9L/jChqe6j7Skr" +
                                                   "SFpYbbXC9mPfJju/q0It4m36UNZth4wUhQq+gngN6yN6RqA9kro7M1H9huZO" +
                                                   "8+jUl0XWe+55maR05jhYSjHN5mj6FBzJh7zB6bo7TmbDRLogXVn1ZCpQxITX" +
                                                   "aEGGUxy3QAwTFtgWHc76YbLorrYep4iIopWKV7OS38rWAsfKvWGsO9aoV+3x" +
                                                   "zO+wEYksSCcKsvfApulsjzHgFXKyVMQ9AiFsspqLQxA2xfhGvEZAAC+BrMMv" +
                                                   "uLsO2ZHMuFLJnNNFktMmQU/HQaYuS88nicXkmcOUprwtLESj4Ky3+6WxX+7O" +
                                                   "WrTz5hmsIcw8w7jtcBbC2jhwlZaPqisac8Rhkm2IwnSw3ocbdkta2mLaX7Ky" +
                                                   "Vmi5MOhyaW72BTgnNr6SrfSaCKPRaeG54KRbATuzwuSm13yxP1tFRnTCEqhz" +
                                                   "g5ElYgo/4G2KU4U1eZlqiujdQTdHixoHB1nBcMdt14dEdikE4j3cRvs9BRFN" +
                                                   "ytn0iR3ISdV2DXgi8BUW5VpZlTvaLLDWTuQ2boWhNPE1a5CYzVApRLdkjfr4" +
                                                   "kh6UcaVEhK6xjhE3AFJG2ik9LBtgrx8ahN1hgVmACckPu1WxOhwYONiDB+5y" +
                                                   "YqUFHgbUsT7rlzPgClqjrJLVwRQotsyWElrP3VNS7QiFl6xhS2Q5E+GbwEzm" +
                                                   "/AbizhiPjxESLAmiEEHv2I6Tk0aXpAA4yhqV8hUOkSS8VNUL4PKshcHn4GCu" +
                                                   "pclGS6BKrfwW2wVD3zEWWy5zbS1toDaNK53YSOsNWKaXWNP4xYhSqBuKMeCc" +
                                                   "qUqTueli5LVGqGW8RmsamwwwfhpdUsYbCpFGhq+qSvDM/cGn51YOqZ7s6ifC" +
                                                   "VcBos1Fs0WRceElOcjkQ9um0DEKkdMMOvRj4pTUvGj4ZK/bgegivIVaG+1lz" +
                                                   "OsiSItDTLTTkisNWIk+jcgiUw4U4DvlhrQEXf1EmnMFS2hhvShVF8FFX7PPS" +
                                                   "NFJgxZJpB/eJFyYFIFcZITDhBZvn8gY5rLwdqKgFR9G9G0pgt6Nz2wfjiAWI" +
                                                   "AfKCVGVgvutaXw1NdWsRc0Y6slDZIhsjm8+DfXGU5xxhDyUK4bUiChcn7ap5" +
                                                   "JhwrDJNRP6N4TeAXFjSWNTme4VXahpZqGzzdWvyQE+Yo6xmNGjBYmGp+iz+L" +
                                                   "RFaDft/AHQgWIn12BnTfLKltbMOTS7DOmLqLhsWuMwoATEcBOkEBQFhWXNXy" +
                                                   "NjTWy9FNh5S7wGuTHwjHI7pqE52Wi0sLICd0zlcaWQAbRJo0buHGI3HO5jve" +
                                                   "UZGmq6AlueBQZYoARSVELyEyxPJliif9C7E4ciyRD/bcUIbYE9V2kx3by6rc" +
                                                   "QXBoH5GcarVlxZHGWdExnTaBs875c4IdmjXHcrnNwKqQocpQdtRwIWPGZDha" +
                                                   "3eX9mUuCRuNzjhISBQXIYM/vTKs0C8uGS/Fc0JqHo5feqBIaZ1mzXQVVlJTe" +
                                                   "2dtXQLrR92hEbsbDRU3HTcKpcSB5DLojAmCxLJa6oFKeEOgBqo9V3F96ZiS6" +
                                                   "5QjYbkf4FV7lO2hBYTFoXfxcKKvCOzsmvNIDboH2W44DSn3EeEJTYHG9SHLC" +
                                                   "0eeHanscI5ymWTc671Iw3QGekLbxNnKShq4MgGwVTWW0wAbN09FynTUO6/PL" +
                                                   "ce+yQY7jOHBCTr253sDH8gzo63ytYQ3ZWpm3MCvXDA86JYDTOUK1Kq+XUD5s" +
                                                   "LtY6cmi81n3JWrcKQfkQpGT63CDFPNMXdhpS+eagxDnJyrIqiPwhwWIGbqMg" +
                                                   "3wXMWMNGv7OU3pmLDZzCFMuBORS2CnPeGAK/jz1Ih7PSU6qzYHK8aibVQpWK" +
                                                   "cnMOJmuDktalOiA8hamLRazJR+WE42mzhEbZ2BMnjlu2A0ls15aEqhHa+sh6" +
                                                   "IZZ2lFOXjKStQZHOTGQPksRuD9yI2cu+RuYLVFJtkbIN3a8AKsYytoeiQ7KK" +
                                                   "jMPSGyt+bq9kYpVV48oKFqimVhw7cRXnVnE8EPF5Q/gFwmZzS5aDQl6fEXy5" +
                                                   "sztkgbLukUac47a3Nw6dw8eLD+43Uqz5wu7oQN4ZTQa7akxoURbMsIAFmzcR" +
                                                   "lGWIgyCIMLdX/WHLsFy9E6Q48jkPsaGNnk7xUGz0pErbhU85i1V9QVpwwgkB" +
                                                   "j3aKaqOFc9tmw4eYtXYjgLDD46jUC1aDs3W1AlhvIXABg8UADR2j2uvoDY9s" +
                                                   "lfm4y11u0ggLytNo3NnGBSrdo4TO52ujoZsTtzbNRuDnQJWGjWtxZ28KraR+" +
                                                   "sz1clll4bmNqvwDjJcdZGEeRvcnsSiLGO2w7XwTbo2XaR8JS3F1XZMi+pJxd" +
                                                   "W+ncyVrM3TVmr8I4Usi0IhYs2nKndIuKXCRA/EnnKh/H+OKArWIWlfOQxF2E" +
                                                   "6yJbajFGkDNNjE0uPcdSU0ZnLYSyDdmJ");
    public static final String jlc$ClassType$jl$1 = ("e25SbjeqJWgnTDewGOLKZN6zaH5gYgws7GBfStt0zJJ1QdUtf4qspc1xcQXQ" +
                                                     "igPvnN2JZFeBmkEaTZ+XO1NTU0fIV/EULIEZflmMxGK8XFbevgNkWSw2mE/7" +
                                                     "muP6uLvxUSRGulTXXQmA08jFmgavDZMgAI+bxqaEUo9g1ffLEDp6PVLESNR4" +
                                                     "lOpWqTAo1AZrD4ekcFd8JCCkjvIhw2rlPjfD4YIfxiVtk5EpUZa4G+Stutox" +
                                                     "DpXhUBqq++naijIBPnI7ATxkKG6DMid3MOLkKlOZ0BThY0AdrgDesi5nGa8o" +
                                                     "NJsulFjrnnlYrBkBEXxTafksGtZ4kbjLhODH0ZvTniq7YLMYgQw6xpBGbqF9" +
                                                     "thDQI4XQKw1cphcq7EKEFi1wiBsV2OnzVUdyLhBrFw4eA1EDmPTQU0tc72WP" +
                                                     "pbwx96IMBfFVCbIbclVhmVlvcbFExbXDaCv5ErROvPEOmbUB85WpAdQIY4oX" +
                                                     "q3WKBbyoDebkxvV2omQHA9jLtmqPG/QAkVR2Uc7pPkUTihwNKPFyi8vK2ggY" +
                                                     "TVEaH+9lJTgnu3S7MISiVYKxJ6zk2OSQIiyXIrlp4sUGsbeuMKpd2zechVSx" +
                                                     "3AEqtDal1MsiarX2+FN70S+DhZwmK+HAMH3GMALsTQwWZBxFzfloLgCWDJU5" +
                                                     "Ep3Xai5PrmufDJUAxdu9K2CysKtsDijqLYPsEWTVzIFjTuL2UYwuoi/DAeDI" +
                                                     "8x7d2AhuGgwMeeKp9mX7YsTzI7iMKcoRT5vkJEkl3QsXVCu5AdfcKSZfneic" +
                                                     "HjKdTrb5bhVmlGeiKuznGw8oiiJjHQzZdxre4bU2V+H51j6Jh1wMtvpy7Si4" +
                                                     "TwW8vDGObS/jnBFH83I5gltU1VSLDVYRtGFzFCqsGIXYBZqXfTTftNxi3zJL" +
                                                     "Gj/Hkw9T6+2gAvZhNQCbjYGaPXIpnTTlNlOgn1qZBisrTYyuTi1vPA8M5vI8" +
                                                     "DwZNYU7DzsinuNLBMaIDNr6Jm0eIOEl0uUggMkYEM1ZobntWMJdlaBKM+kYc" +
                                                     "lly+OlXYZBaDPUqvx1IEsHE0YMjPlpmhY8tkscgvMIhAMTMF7EfDhPYSYBg1" +
                                                     "Bx7nLqHVfCufoOkGjiJcXYPursAlgN0cuigJXTbqgDPQrPu5wmBHLiZwlFzR" +
                                                     "KGjrYwLQwgkhcopI41HxtqadXSw7QYcoR5OAKnhAnctwpvu5RHNWdWZb1kQP" +
                                                     "xqpBz3JyXMtFZaxDiVlgBbOcPFLeKAOaX/rlGrrkZjxIqQTJQk9KOC/Wjrcm" +
                                                     "XSkHkm7Il0mUt9ZiCTKL8BDEXtUe2to+OLSyGNM1zfaNdQR2zXrSKZgyXHO0" +
                                                     "15qt4Hous1GyP6v16eDuV+WS1WzzYjPkoUMMycIICY2PFph21p5Yh5A9+c4m" +
                                                     "DGnf3KsCuzo4+AaQcXVhRYt1oB7GSk9ZQnACZpcaVbFxJ72CLl0S1qLVLkFn" +
                                                     "MLV1UiKeTewGM2oFn3OiYjOcuYUj7WguaYLIk+YcXxYiWYsUgJ3b/AzQHKRw" +
                                                     "WGajiR/uh0PSL5dhfzAvKcFcwlNPrCRtV3gwbwnlfGgzfLNXlqbpLGSyHQCK" +
                                                     "9gEcXTSc3EJ79JQue355NvmQPfNQAMvk/ojjcA0vD+PRDYgY8/nEP+sFOiys" +
                                                     "9OIUq7nBsq2CLif4RGK+5cmhA7eWJPqrEEmW0O6y27jwMdOTNZNadFQlg2R4" +
                                                     "acHpc4UyLQA56HjL4ArDbVeQtFriBpPuaFJwFY7aGiM2RBkZaUaPwttS8syu" +
                                                     "1LW0PDC8pduKlCnZJU3dlM5VmVx682QIvUEnnNXqSK9ErIyGfVxZWsky5Nm0" +
                                                     "ctjDqig+cAtxHmsALiwVvN07puJwu0ykN8G5i06XYsGcbEk8mxKCrI8GSovy" +
                                                     "WZtvxJyC3QVJSWWfVGf8dCH5lK0Ox8Nhw8V+VuStiJbrHmkgbtwv3EieC4XB" +
                                                     "1SZaMHna8FkdnXuZuCzJuLMUMvSNmrQ8R+sP+K7GERFfN/MA72GAlo7hIGPR" +
                                                     "ZJGrCcuNOzfKi7Gs9K4aUheho4NXaOGFFTSmPluKA3C46pkBHs3bhcWQnbZa" +
                                                     "qqwXoFWLjoNnMiwyLE8Mou0zJVcimVeXKjU5Jb7u95txr5NQIk+Yd7ogwvJg" +
                                                     "zC1lBQiDk0ubEq/PYOLoDHbRM21juGGBQ7QrMEmNTWSsHU7HdgTNCxWezPgY" +
                                                     "gVorcYpwTEWp3eCUwkUYuCCBdYasOFI5IkHCggwnncImk+anYDDVvhd2oZNo" +
                                                     "nclvwsN0UvhhSNdEQfdg7Ed8QFNkuWIJMVh1fMksuYVR+9wiiiaD3srWMAUN" +
                                                     "h8s+x5LlYe55jIvbi2V0JjgS6RZdFDN0mcq+b5RbmF4dzYWxEwmjaPMMWMfu" +
                                                     "RG1AlIT3TuBYnEgUzm0KHeVLeOFifuvGCqkVPHUQjCnYVZXKKhencGmJp0CO" +
                                                     "zIpYznuQgIeRVlh2xTML8ejtXMSEhtPR3p/2awDcjl0ibLNUdpOdkwiadwHw" +
                                                     "hR4HLHQxapA9rwgIAjC8Pfu8GICHxYp0/XgKVdKOvNhLnSHQ+nz0NouSjFc7" +
                                                     "aZejob/fB3OTam1QLzGbbDBF7wUPTdPQCZRNmueNf9grZxZwsF7vfYZeSRBd" +
                                                     "qslO2Ztb3ZsEp+hWtrZMHxvo49HPlUPdkcOgq159lNdrcCGmIZYNk/02Qq8M" +
                                                     "8oKtNLNULkscQBW+ria7GlttVyR4e4lwAJHPrESJPS6BkGai+oThnNyt9jEy" +
                                                     "BPvIPVOshZbaEBagTnusG8QHNA3BgpNQaIUs1qtwYcUhB1rpDnSYIjjt4eul" +
                                                     "1WVhINuDew5cRVvS7Sp8Ak7Te9jlQu3kyNrV3CoPaLZimzl5IaMjjdJFNkXV" +
                                                     "LKiLI1vU7aEB1OW+H1vVl1QoBsFAQz0eiU+L7TUVYLjPKnjXLefhYYp4Eh+v" +
                                                     "HflrJlb8hnXoiECtoXN8RIxlsjk2SnheLLs+VqeoG4B8GSlaIEQyRM6MSZ0n" +
                                                     "gHXmWU2hMyl6B+po6sWedzVp8rrrFEeXWMlSKDY/otwqbinPEY+8Q3pAh0ok" +
                                                     "VgHLPZw1KYXuYRjE5gNAiwTZSSun2R2EQ8si+KlhaAVZEWy8PlWdGS1oo1tE" +
                                                     "R3WnEsBJLhIySJdH7tydGgfhQWDtYSAPCNyxPAYJSO5B0tuDhhGS5JXFy71A" +
                                                     "vvZVAnkBfiSSu/SKD1yLDz1M8br9nr1/tve19Fj+2WPZjLNritH7v1qa+y29" +
                                                     "6Kf/3Od+0ld+Bn76PhnG7GZv7srqO7LgFGSvSIy8tj/1cBvvuZL/lruUs6eY" +
                                                     "+/o7H8+te3Sqf3BOzCuz677hntwn7uuPPMndt70qCen6n35I5X1XKi9Mz9um" +
                                                     "vl+5r7/05ObyqrpL2f3BJ4g+kSP1TY9l4gRe38TdmRm9oLpltt6P+eCjMVyW" +
                                                     "BaGTkU14S4B7OPS21GevxZ/vZs/kTly8ZibNqYz9J2R9y2P88PT8jdnsvZ++" +
                                                     "r6U/pKxfP4nxSkm8r7/rq4v58XSpn3idvr92LX6sm729Dbq+ovs8P9NO51zf" +
                                                     "fu61mPrI9PzT2ewDzX39yT8Spq6UXrqv5T8cdh6mwsXlNQev6LZdEzj5bQ9/" +
                                                     "83UY/jvX4q930wrXSWSWlZ7zEBdPsszP7ouryv7Yg/pVLF+L18tl+7uv0/fz" +
                                                     "1+Ln7lMkX7imqL/wSIyPdvLcA0Q9dW9QbnU3+/Krs+if/8j/0yT6j378+bp3" +
                                                     "2rjuyy74yF12+vNXnXj+ahzj4lSmAR0cH/ty4SMfff57p8ijffERyx/56Cc+" +
                                                     "89GqehxBX8WIvoL/a+/fr6rXEe8/fJ2+f3wt/l43e89X2+hrQeKa93z7IuaJ" +
                                                     "g/ji/28HcZfK/fhJxN1V8s9/zye3zz8p7CfV9ambuo6vFP9zryX+L72u+H/p" +
                                                     "dfp++Vr8k272pge7u4l7nCzqlbXrBwTvedU3endfknlf+Ml3vOkbftL813ep" +
                                                     "2A++9npWnL3p2GfZ49nyj7WfrZrgGN+WfvYud/5OBF+eVrxK9Nr+tZtaH8f/" +
                                                     "C4tSOEIlOAAA");
}
