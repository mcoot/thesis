package conf;

import jif.util.HashMap;

/**
 * A system to handle the submission, approval and session allocation of papers to a conference
 */
public class ConferenceSystem {
    public Organiser organiser;
    private boolean allocationsVisible;
    private int numSubmissions;
    private Paper[] submissions;
    private HashMap allocations;
    
    public ConferenceSystem conf$ConferenceSystem$() { this.jif$init();
                                                       { this.organiser = new Organiser(
                                                                            ).conf$Organiser$(
                                                                                "TheOrganiser");
                                                         this.submissions = (new Paper[5]);
                                                         this.numSubmissions = 0;
                                                         this.allocations = new HashMap(
                                                                              jif.lang.LabelUtil.
                                                                                singleton(
                                                                                  ).
                                                                                toLabel(
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    readerPolicy(
                                                                                      this.
                                                                                        jif$conf_ConferenceSystem_O,
                                                                                      jif.lang.PrincipalUtil.
                                                                                        topPrincipal(
                                                                                          )),
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    topInteg(
                                                                                      )),
                                                                              jif.lang.LabelUtil.
                                                                                singleton(
                                                                                  ).
                                                                                toLabel(
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    readerPolicy(
                                                                                      this.
                                                                                        jif$conf_ConferenceSystem_O,
                                                                                      jif.lang.PrincipalUtil.
                                                                                        topPrincipal(
                                                                                          )),
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    topInteg(
                                                                                      ))).
                                                                              jif$util$HashMap$(
                                                                                );
                                                       }
                                                       return this; }
    
    /**
     * Upgrade a paper's policy such that its authors may only be viewed under the double-blind conditions
     */
    public void handleSubmission(final Paper paper) { try { if (!this.allocationsVisible) {
                                                                this.submissions[this.
                                                                                   numSubmissions] =
                                                                  paper;
                                                                this.numSubmissions++;
                                                                if (this.numSubmissions >=
                                                                      this.submissions.
                                                                        length) {
                                                                    Paper[] newSubmissions =
                                                                      new Paper[this.
                                                                                  numSubmissions *
                                                                                  2];
                                                                    for (int i =
                                                                           0; i <
                                                                                this.
                                                                                  submissions.
                                                                                  length;
                                                                         ++i) { newSubmissions[i] =
                                                                                  this.
                                                                                    submissions[i];
                                                                    }
                                                                    this.submissions =
                                                                      newSubmissions;
                                                                } } }
                                                      catch (final ArrayIndexOutOfBoundsException ex) {
                                                           }
                                                      catch (final NegativeArraySizeException ex) {
                                                           }
                                                      catch (final NullPointerException ex) {
                                                           } }
    
    public Paper[] getSubmissions() { try { return (Paper[]) this.submissions.clone(
                                                                                );
                                      }
                                      catch (final NullPointerException ex) { return new Paper[2];
                                      } }
    
    public int getSessionNumber(final Paper paper) { if (this.allocationsVisible) {
                                                         return this.declassifySessionNumber(
                                                                       paper); }
                                                     else { return -1; } }
    
    private int declassifySessionNumber(final Paper paper) { jif.lang.JifObject sNoObj;
                                                             try { sNoObj = this.
                                                                              allocations.
                                                                              get(
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  toLabel(
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      readerPolicy(
                                                                                        this.
                                                                                          jif$conf_ConferenceSystem_O,
                                                                                        jif.lang.PrincipalUtil.
                                                                                          topPrincipal(
                                                                                            )),
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      topInteg(
                                                                                        )),
                                                                                paper);
                                                             }
                                                             catch (final NullPointerException e) {
                                                                 return -1; }
                                                             jif.lang.JifObject sNoObjDeclass =
                                                               sNoObj;
                                                             jif.lang.JifInteger sNo;
                                                             try { sNo = jif.lang.JifInteger.
                                                                           jif$cast$jif_lang_JifInteger(
                                                                             jif.lang.LabelUtil.
                                                                               singleton(
                                                                                 ).
                                                                               toLabel(
                                                                                 jif.lang.LabelUtil.
                                                                                   singleton(
                                                                                     ).
                                                                                   readerPolicy(
                                                                                     this.
                                                                                       jif$conf_ConferenceSystem_O,
                                                                                     jif.lang.PrincipalUtil.
                                                                                       topPrincipal(
                                                                                         )),
                                                                                 jif.lang.LabelUtil.
                                                                                   singleton(
                                                                                     ).
                                                                                   topInteg(
                                                                                     )),
                                                                             sNoObjDeclass);
                                                             }
                                                             catch (final ClassCastException ex) {
                                                                 return -1; }
                                                             int r;
                                                             try { r = sNo.intValue(
                                                                             ); }
                                                             catch (final NullPointerException ex) {
                                                                 return -1; }
                                                             int result = r;
                                                             return result; }
    
    public void performAllocations() { try { for (int i = 0; i < this.numSubmissions;
                                                  ++i) { this.allocations.put(this.
                                                                                submissions[i],
                                                                              new jif.lang.JifInteger(
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  toLabel(
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      readerPolicy(
                                                                                        this.
                                                                                          jif$conf_ConferenceSystem_O,
                                                                                        jif.lang.PrincipalUtil.
                                                                                          topPrincipal(
                                                                                            )),
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      topInteg(
                                                                                        ))).
                                                                                jif$lang$JifInteger$(
                                                                                  i));
                                             } }
                                       catch (final ArrayIndexOutOfBoundsException ex) {
                                            }
                                       catch (final NullPointerException ex) {  }
    }
    
    public void setAllocationsVisible() { this.allocationsVisible = true; }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1501367069114L;
    public static final String jlc$ClassType$jif = ("H4sIAAAAAAAAAL1cC3hURZau7kACCRDehHcDAQxIAogoBhUIRMIEEgmgRjTe" +
                                                    "dN8kFzp9O31vhwCD4oPBJyoK6iisuqDgIKKjO34+UNQRfIwzuo6gruLq7srq" +
                                                    "4Gt8fqvj1jlV91W3+tIws5vvS9XtunVOVZ3zn1OnHt27jpLORooMXaY1lZor" +
                                                    "k6pROk9rqlVShhqr1eMrF9GihugP97wau/2C5OEwya0nXTRjccJQmtRq0lVJ" +
                                                    "my16SjNXmqRn9TKlXSlLm1q8rFozzPJqUhDVE4aZUrSEabSRS0momvTUaImS" +
                                                    "MDXFVGOVKb3VJCOqk7Sh5rhulqkdZllSSSmtZdiVstqKuGIYlFMullpMuiRT" +
                                                    "ersWU1MmGV5NO85rx5VGNV5Wy99Vw6fyjhSJWOz5+NjgkDMb3abxZbfednHP" +
                                                    "R3JIYT0p1BJ1pmJq0Qo9YdL+1JNurWpro5oyZsZiaqye9EqoaqxOTWlKXFtF" +
                                                    "K+qJetLb0JoTiplOqcZC1dDj7VCxt5FO0i5Cm1ZhNenGRJKOmnrKGk5uk6bG" +
                                                    "Y9anzk1xpdkwSX9HLGx4lVBOZZFPxammmpSoapF0Wq4lYiALgcIeY/EvaAVK" +
                                                    "mteqUn3ZTXVKKLSA9GaaiyuJ5rI6M6UlmmnVznraBAEPysi0HBShRJcrzWqD" +
                                                    "SYrEerXsFa3VFQUBJCbpJ1ZDTlRLgwQtufRzdMH0DasTcxNh7HNMjcah/10o" +
                                                    "0TCBaKHapKbURFRlhN3GVW9W+j99dZgQWrmfUJnV+d0vv5xx8rBnD7A6gyV1" +
                                                    "ahqXqVGzIbqtscfrQypKpuUwCOqGBsr3jBzBX8vflHckqWH1tznCy1Lr5bML" +
                                                    "X7xg7QPqp2GSX0Vyo3o83Upx1Cuqtya1uJo6R02oKTCRKtJVTcQq8H0VyaPP" +
                                                    "1VpCZaU1TU2GalaRTnEsytXxMxVRE2UBIsqjz1qiSbeek4rZgs8dSUJIHv0n" +
                                                    "Q+l/F/q/m+e3m+SSOWcsXWyoqUrKxVg6W4+mW1VqwEsXJ7SlZotqaMbSqGKo" +
                                                    "DYaZjmm0BkU0lzo+NlCDXGqkovhhaYX9sm6lYaqtpfRt8v+hjQ4YZ88VoRBV" +
                                                    "wRDRAcSp7czV49RJNERvTc+a8+XuhlfCtkFwCVGsAvdSkTsJhZBrXzAaplSq" +
                                                    "kuXUuKnT61ZSd9G8S64emUPRlFzRiQoUqo70ONcKxwNUoTOMUhj+69nJSzac" +
                                                    "Onh6mHSup07SmK02Kem4WVsxS08nqDPpaxctVKmfSaB3k3rYvGQUaUwywOcb" +
                                                    "mU+kZCmHCZANptAvFg1Q1s3C9Ue+fWjzGt0xRZMU+zyEnxIsfKSohpQeVWPU" +
                                                    "Zzrsx0WUxxqeXlMcJp2o26BjM+nIwAsNE9vwWHq55TVhLJ3p8Jr0VKsSh1eW" +
                                                    "VPLNlpS+wilBfPTA515USwWWLdD/nNU81+BtnySkfRmeQO3CKNArn1mX3HLo" +
                                                    "tf8+JUzCjgMvdE2IdapZ7nIawKwQ3UMvB0WLUqpK6713e+0tm46uvxAhRGuM" +
                                                    "kjVYDGkFdRZ0WqRiXneg7e3D7297M+zAzqRzZroxrkU77EFCOcnng2vheaNr" +
                                                    "kLS1MU5/qNOJU8dHu2sUL0606jGtSVMa4yrg/MfC0ZMe+8uGngwHcVrCpJoi" +
                                                    "Jx+bgVM+cBZZ+8rF3w1DNqEoTHqOzJxqzJP2cTjPTKWUldCPjsvfGHrHfmUL" +
                                                    "9cnUDxraKhVdG0EZEFTaRBz/eEzLhHeTIYlQcxZf0uYGO0aLxkPjBo0FFQ3R" +
                                                    "/l+NLEtWzv4A9Z0PboLGSlqURkFDfDZXYb8Fw4O5u9mqPNRXucp5DSYzQOwD" +
                                                    "b7/TRZHYV5GRF6KdFMRUI5rSkhawqKfPN7TWZJyKW42hedMYw9TnUfHZAVNK" +
                                                    "SRhxOsEwl7AIX87pSKZgum5XUqgnlMqoDgCp3Y1aiMMaoqddtz6lj7p2apgL" +
                                                    "sgckIzpoFBhjXiqSjEbilns5A2CMPKxmHWE6TTdEt/S77anev9k4k83Fw70U" +
                                                    "vtrTJ1b8qmHKw39A0ANAhonSWqgq1MczcTZEv9r6jrrw1B8+Y0aqr0iI8WOS" +
                                                    "hj5RLalADMmfIPRMIRcYxwzaqyIfLDj7qTfc/dDR92tnIJZdCoAAwRejcg27" +
                                                    "RAdphXeusPtTukhP2l1qiF7c/0/jhzx1wTVuMQkErtobdt6V9/nJP9yNw7Zh" +
                                                    "MEqAgU0QCAVIp7H+oq/wKMjdSbeeBvR7780D7XM/Y90VcSCjOHty371Higau" +
                                                    "5pqFBmfzViGbK1X2eXQZ4ig7Ulr93DN5C192KRs1SEWwAisyfUI601HAAsp4" +
                                                    "tEyes3TT1FtdUj1z1DvLyn96/VHLAObYUinxDlCgdA8zd9yTAze8u7bG4lHF" +
                                                    "hlrjGuq5rGhKsgM99GL8NN0AzyBEH3MVo4XOHofiB+s3vTduGBO2a3bh75+Y" +
                                                    "vW7T5sd/N4UFKN2or+t59gxCmNMD5mcnsS/1rCtJTzeEj/NZ1QamoKStHO9H" +
                                                    "lhehY4WV5hBPMFQJSx8nAIiuOvO/Nv6tjQYAOfWkR4tiVCXohAkrLbqgA+9p" +
                                                    "fzJJL5dZoVuCMCDuDmnE5YHQWH3ZrrsGVZz1KVqsE20A9fAOf9i4RHEFQpMf" +
                                                    "aP0mPDL392GSR+M1jMLoqnaJEk/DHF5PF2lGBS+sJt09770LLra6KLejqSFi" +
                                                    "pONqVoxznHCVPkNteM4XQhv4J+PZQ/hUng92hzYhgg/LkWQkpqMhOQl1FobH" +
                                                    "EpO2rCWUuBBN9OT8BvG8h4uvSbrqqWYlodE43/DMZejK1RhbgG3fsWt3ebed" +
                                                    "29FSu6L+qDZNPm91AQrrMxtad+/QIrzpcbKhMeuxCQbJCIrdBJiluZlBep7U" +
                                                    "SGyOg6FwOOdUwvPRYuC4ko6/WOqnAbcutzJEa01v+/rlWoRkd9z0sJRvkoEi" +
                                                    "4J3oGl2Qt1NDeGfGyDpl+KZXZOj2Toeqf9p65lt7H7On14FCFOAYw9SXHsj5" +
                                                    "45KlW5gKXWG7e+aDlY9r64DvWQzLNCa2ZYEDa7EHNgwGVsKXqk/w/CH3wAjD" +
                                                    "8lVyLOdwLOcauMUDn3SO6J/pX4j+/w3+oRkogJyaawVflUfsZXmSLg9DNYbf" +
                                                    "xVBdtlIf1c53INSrb73259INt4Zd2zSjfDslbhrXuLtDcg3oakRQK0hR+fFD" +
                                                    "a57csWY98/u9vZsOcxLp1gff+unV0ts/eEmyzu1q49Fa5AzJoGpsauRHeeur" +
                                                    "jszbjj66J/g5jBKoowPbxaKqhLeoQDNskOPQboJkI6yOcV7xKlg0p5N8Fm1N" +
                                                    "QJC0I8Pbnamz3Ttn+Yv6maQHLu1rLPeE4yYu21ftHoH1kwn0vx/tyWaepyXu" +
                                                    "85/kkKMLsTwqXxpzqYLvLODMTJ63enxnbyUe16O4v2gs0QzNCsJS3p4N5MRX" +
                                                    "yHomeL8+MoJf+rzfjuy9X18oLOKcLuf5GtH77cL6q71U/XjtS2VUWPUylyU7" +
                                                    "CBkga3JtIEJ2Yi8edeCw048Qb9H13PIgu5EqsFHX46qScMFkhwwmo1n/wk/z" +
                                                    "fJsEJk8xmEByrx8PQPXPPL/Lg4ce1Ibr0o2tmmEAJGRY6McJH5Q1L2ChUEZw" +
                                                    "vw8Lz2ePBQgFULXAaRfPd4hY2C9gAam4XsM7ZVQBWOgja/I3gVh4AXvxR0fx" +
                                                    "L/ix8EIQFnLoCt6Fg+dlOJjCIBr+iucvS3BwMBAHQPUSz5/z4KDACAbBWE71" +
                                                    "n7K2BRCMkBEc9oHg/exBMBIKx3BO/8HzD0QQfCiAAKlG8dr/LqMKAMFoWZMf" +
                                                    "BYLgMPbiE0fjh/0gcIpSZJAzHWJQj9tPbILff0rRpvW3fDeAhj71JI8H/Rj+" +
                                                    "L9AT+EFytuGi/2LX4U/f6D50N+7kdGpUDBbDi4dC/jMfz1EOjqebFwgjLH1m" +
                                                    "BIKAnOG84ntZIGegjOCgDznfZI8cDM2HcU7/xvNDInJ+EJCDVIN57bdlVAHI" +
                                                    "GSpr8t1A5HwLveD7hTWswIecb13I8R6rUv9tmK6DrfNPWrLvqoHGdSxoK7FR" +
                                                    "onaYpRj7c1KR7u1DOZMLzOIbMd62QdOFrg4NqGmSSOYjVeTF4ssCWxJ4FNSb" +
                                                    "/ufS/wt5XmuSxf/IY5paJamm+PnP/w1jVE5XK8bDfdlSfInHNT5NNER7Tbuz" +
                                                    "semKGfsxKC5E4WHEWsfEOMa7fOFExXXeet4zZqnuGqJHHrrhwIhPlvTBw0NL" +
                                                    "Te4TgvlKslw8EYA9G1reOe+dfc/3v+T1HBKuJPlxXYlVKni4QrqaLSnVaNHj" +
                                                    "sY4kN6zQClgThYkVW1/unS2LuXJbeb4URFYAcA9144unUP+gxRMkV0OiI4au" +
                                                    "oTPSTLwEgAKRzZj2nkyIrdxvgcehJEQEnwL4w8gOzPAtnv9J9Cmh4dn7FBzx" +
                                                    "AM7pzzx/XfApoVGCT7GjCqj9hozK51Nm28T9ZU2+6SOe6/iUUAR7Md52ILRA" +
                                                    "9ClOUUeHdyshMywnlUcXPKdPK0Fs55otmlE8EQ9YJJAuZ6Ltg42UIYo62QhC" +
                                                    "5/IVj1tCU+TgCNvgsHGRG1cTzSZbvKcYD9mxyiLaM36ssfnbvguvOO/7xejX" +
                                                    "wlGMs4ZXky5N6Xh8gb1ihfQ0xs8kM5BJRG+KULcRMZJqVFPiEWvbOjISxj0y" +
                                                    "oiUi6AcuXF3z4a82rrkIsw+v3b7mwouS9pavvRVSoSQSuuk7b8iNao8dLWv6" +
                                                    "ydquPZPp53M+NHuYX+Pbb9AXQXIKbrZIT8XmtCZNPMda9fiAR6ffv/V93Gzx" +
                                                    "aUGcR+bj1O/sv5x2z+ziIc+1bfjHHR7Dx8Hyc+LhQjAjdmbn/F0vnTMmujFM" +
                                                    "cuxNTd/NFC9RuXcrM5+1usizoTmMiRkEepYTOo9BrOFn6QlfqCrg3S8gqaQO" +
                                                    "KhrXE+qxlZlMJkMhQny8mB9jW/Sh2mO6J9w1D9Uxx5Fp15y5B1b1fOYHMu3F" +
                                                    "Q7q4AzYaijKBHKq8iaJjRnwG8oWDj9AsEoK3fDnzvmw5M5HFWDlLeX66251x" +
                                                    "t3Bx4HIGqE7j+UQXNZ08XNscQlCaZ/lhmNC2E/t+yullLXqrWrZMjZWt0FPL" +
                                                    "y8ChxagN4UNca5xAAwN8xnmVz6E87jhhWq5kGGoDU3TzMRXNKkO6zPHkDX7n" +
                                                    "3uCLMzmZnj1ZKBeSGJKZVgTUE7yGO5LAmoWY9uWdzcF4AV24EC/gXtxoLvd/" +
                                                    "Ic5ma0hFATRZ8cLKDPGCfQXB3nAVThFOYM91iR1hhNbiYIdAArteoWFCPAEb" +
                                                    "4Li0BNQt4PlcN3ax91dlH0/ggmEE5zSf51VujsDwaiGesJcZUHuejCognojI" +
                                                    "mqz2EbvjiXXYi5scoKzzY8db5OgcdoRQcKDrB3l+n0TnmzLHiCHYygtdCsll" +
                                                    "2JW1VG/oa6/MqCvcEhzEh1fJ8xk+Xf06e13hSAZyTnN4PlPU1VZBV0jVn9ee" +
                                                    "JaMK0FWRrMnZgbq6E3txn6OYO/26utMV+8FncKChFW220w41d7gmRLs3+JfL" +
                                                    "VXgbz2929QZrFjkXXoZmuoGJu/7brrh1a6xm+yQr+rnJpKsPPTkhrrbzsJ+x" +
                                                    "ysU+VtjdwJtVgOLTqUfvx3Mi6IH0lI3Avq9ESXJ/5vkP4gicud0dtDrTCOxv" +
                                                    "kTN4w2U8H+LRimeHh0WlM1PNPCjd0f33rxwtqjyAOzThqAbXdnwX3mJqplgm" +
                                                    "naRTsjumCrfjvbJlLI61uzlF1s0SdzdN0gjttuqpZIvGb9dA4Msuu0WUVDMu" +
                                                    "oiNJCALgBdshirQoiVhcdfaOIyc1QnfUWERp1NvVSOPKiB0qlLApYjrLKiB5" +
                                                    "lCkIHh8LEjhUeIIh9ElI9iK0n0GEPnt8/Pxn74sTyxP6igTb/qgr2JW+8ukJ" +
                                                    "hywo8nMybO9AQLz3KiS/pdOiKBF7TnGtWju161pMFuxJrp7w3nHA9C37y5aa" +
                                                    "7z/cY3XvNDbqpEe0bwiFdGZEvTlhxl7m8g5l7/LgcJ9M49Ap5fk40eW9K7g8" +
                                                    "pJrKa4+XUflcnrOFdrqsyQk+Yndow3DxkePf9vpdnlMk3heppsFi3FlsLLp+" +
                                                    "/8GpdxzZiIvc4MsfAmV8W3x/9dcrX7O05Bwyo8OYwcdyqsxh8Jj3E/kciPG0" +
                                                    "vQp2qZWbCGq1zdqp8hgLJF+gwUj1DW/2QfKZzeMTZIRvng+A/l8R+pD8AZLX" +
                                                    "iOTKY5tnRgaXjdvqMPrBlv92SwFlcBw7vHjaMJpzGsTz/iI8xR1epBrJaw+Q" +
                                                    "UQXAs1jW5MBAeOIOb9jZ4Q35d3idIkgXQ5gLOh4rU8rjmZUS7nJspaCIsRXZ" +
                                                    "tAo1z6VT5D6ebxGEeYxpFUju4vlmF2lAlwsD3vWCJN8kPZpVM/NJpR0PQKuP" +
                                                    "yDouAHGQjGCXCMRwv+yBaN/ZAU4P8/xBQXbhgQIQ7Us1UHu3jCoAiMNkTe4J" +
                                                    "AmK4P/ZihI06WiACUSj63CvkQZasMgoZHFJ4rGtpm0+DjCLrBq8Cp1QROF2w" +
                                                    "b/KGS44pZcYG6k5wDCbfb0P5ftNjZJOzI2vjOzLwdYwMvgy4FaAdlMPj6dn0" +
                                                    "nRGEy7FgNivAZ2uHxl803yGb4aimwK+tAo/bkBk0uKoL6PP1PE8dn0EDSRvP" +
                                                    "l2c2aHmcfDJwOZtT38fzW0TMhJ60CabJCO52E5xoxAoOREXvsSANX707vog1" +
                                                    "XGlHmOFzgoYOFaqdiDW8AHVYg+6k9rj4QdWXkfr8AAdZD8kcGn+K45O5yL5c" +
                                                    "oKtlUBBcZA8ZgecmEI7p4uxdJF4P6cM5reJ5u4DGcKPgIpGqJ6+9QkYV4CJ7" +
                                                    "y5pc6SN2u0jcJQs7m2th/y6ZUwTpmxl2bzEcp3r2x+juQl+MThGDgj2O+6Kw" +
                                                    "wiNn8dFt5/k9omA7BMEiVTmvfa+MKkCwZ8qa9N8NcguWWcJaR4oL/IL1FIWO" +
                                                    "eP3IHN7MLpkfYeFzeB3zZZhmGz5Te0WBt3nCZ8tyIbkOrVeqCnhzLiTXWDzC" +
                                                    "69qsSC1cF2C5G9ByIbnQ6cpF+OpihqtjxtN4TWU8F8dGy8/7bPTm7KEEwTkZ" +
                                                    "xzndzPMbRChtEqCEVGN57Q0yqgAolciavCkQShuxF1sc3Gz0Q2mjZ2J0x9M+" +
                                                    "Lc0L0NK2E9ASyhybFeZj+96nQp+X83yeIF33fCw59gCSKp7PcpFmNR/jhtA5" +
                                                    "nHodz32zgGs+nikjuMxNYBLthOZjOMRT6HzVtPLvmZZ3ONPozmNNy7td0/Ie" +
                                                    "VNLDaB6PHBe/NntafiIANk9Bcr9JBmQYpqAX+6oliLdOBgzB8gtlBPN9lv9s" +
                                                    "9pZvX7UETgt5vkC0/BcEy7evWkLtGhlVgOX3kTV5bqDl78NevOqY+T6/5e/L" +
                                                    "fnbeIZuddwTNznuYYA9mL1jY8SeVfHRX8dxzuRgYviMIFqkqeO3LZVQBgp0j" +
                                                    "a/LKQMEyg/jQkeIev2D3ZJid0avM581cJ/MqfHb++ERm593YM7gH6J6duQFD" +
                                                    "chSNOOPs/FtIPrV4hD9us/2+uFXsNuAv0IAhedrpyjP46lkRV84Ws2vLHy4w" +
                                                    "Vdh3IRqi1d/8uX/7SfqL7Kuc9rcjkIn4zXE4FCctXJD38fzXPv3JfZ2DoSZg" +
                                                    "08zJt/PcH6Rdlkl05Coc73ei84EZjJzC+bVZ05nP+fyYvY3ALi+ZzDkleR4X" +
                                                    "bCSHCONDqjJeu1VGFWAjk2RN6oE28hP2ootjED/5bcRb5MgMfCNZzJu5hec3" +
                                                    "iDLL6Z69zGqhcBHntJHnG0SZ9RJkhlTn8to3yqgCZFYna/LmIJnl9MBeDLQF" +
                                                    "RAtEmTlFnihNtNZdma01J3IC1gov/wrJNxmsCd59j+xHI6cfbQWJWyywlXwF" +
                                                    "VdUEnosb0MfYYgGSfjwvdJEGDHh8wDs4KskZY5LeVJIQhc10bsO0ZbdPj3fn" +
                                                    "i3mPyqzB+cA68ZhghVqTsFNTHHVP8iNgkh84jGxadmSQZtz8oijv9RTP7z0+" +
                                                    "zQDJPTy/MzvNVAS8g3VEzlkm6Weo5kzfV7GyVA4u+sbyTu21xudTztyslFOF" +
                                                    "/ap2RFrll3KVXzmM7NzsyFA58DMO4q/ewElcke+HtNiPP0V3by3sMmDr4oPs" +
                                                    "SwzWDzR15Tc33V9Sdj3nJlNqk4aK7crmVLztlnO+STrBzW14vsD+wl5PvEAJ" +
                                                    "35guZd+Y7mBeokg6m9pnmnDnYT/PX3TL/ZizaQA0Gr3fZoYLmWn2S2UN0S8m" +
                                                    "T5q998CY/fzHDjJeC3coHto6b8HqL6ey7z93piuQVaug0S7VJI+ty3jY4f4W" +
                                                    "qMjN4pU7t+R/euzpOtrzsxy9XcZT5MZpkRPRXeV8I9j90xbun1JriC4na657" +
                                                    "YX3vy/G7Ll01Y1EqTaERg6/8WldFgNcV");
    public static final String jlc$ClassType$jif$1 = "7NSb3YfMWUYZjxV/88HF1n3DNrTsjprqvJ/Pt2/YSvXD7iv+LyZF2824TgAA";
    
    public ConferenceSystem(final jif.lang.Principal jif$O) { super();
                                                              this.jif$conf_ConferenceSystem_O =
                                                                jif$O; }
    
    public void jif$invokeDefConstructor() { this.conf$ConferenceSystem$(); }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Principal jif$O, final Object o) {
        if (o instanceof ConferenceSystem) { ConferenceSystem c = (ConferenceSystem)
                                                                    o;
                                             return jif.lang.PrincipalUtil.equivalentTo(
                                                                             c.jif$conf_ConferenceSystem_O,
                                                                             jif$O);
        }
        return false; }
    
    public static ConferenceSystem jif$cast$conf_ConferenceSystem(final jif.lang.Principal jif$O,
                                                                  final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$O, o)) return (ConferenceSystem) o;
        throw new ClassCastException(); }
    
    private final jif.lang.Principal jif$conf_ConferenceSystem_O;
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1501367069114L;
    public static final String jlc$ClassType$jl = ("H4sIAAAAAAAAAM17e+zs2FnY3LvJbrIJySY0D/Likixhg5O1PbbHdhYqPB57" +
                                                   "Zjx+je3xzDgbFo/f77fH4xBEkQoIWqA0BCoeamkqFRpCWwmhPqgAqYUUVLUI" +
                                                   "tUUVDWqLKKJRS6UWVX1Qz/x+9/W7dy/kDxAj+Zwz53znnO99viN957NfHL22" +
                                                   "Kkd38iw+eXFWv1ifcqd6UTbLyrHp2Kwqbeh4xfoBAPzUD37jc3//qdGbjdGb" +
                                                   "g1StzTqw6Cytna42Rm9MnOTglBVl245tjN6SOo6tOmVgxkE/AGapMXprFXip" +
                                                   "WTelUylOlcXtGfCtVZM75WXPu5386I1WllZ12Vh1Vlb16Dk+NFsTbOogBvmg" +
                                                   "ql/iR0+7gRPbVTH6ltEtfvRaNza9AfDt/F0qwMuKIHvuH8CfDQY0S9e0nLtT" +
                                                   "XhMFqV2PvvLmjHsUP78aAIapzyRO7Wf3tnpNag4do7deoRSbqQeqdRmk3gD6" +
                                                   "2qwZdqlH73rVRQeg1+WmFZme80o9eudNOPlqaIB6/YUt5yn16G03wS4rdeXo" +
                                                   "XTdk9oC0vih+3fd8Il2kty84244Vn/F/7TDpfTcmKY7rlE5qOVcT3/i1/KfN" +
                                                   "t//cd94ejQbgt90AvoL52W/+/W/48Pt+/pevYN79GBjpEDpW/Yr1mcOb/tV7" +
                                                   "6A+RT53ReF2eVcFZFR6i/CJV+XrkpS4fdPHt91Y8D754d/DnlX+2/9afdH7v" +
                                                   "9ujZ5ehpK4ubZNCqt1hZkgexU86d1CnN2rGXo9c7qU1fxpejZ4Y2H6TOVa/k" +
                                                   "upVTL0eviS9dT2eX/wOL3GGJM4teM7SD1M3utnOz9i/tLh+NRs8M3+i9w/e6" +
                                                   "4fvcdf1D9eibmI++vKmckh1WqV6eZVaTOGldvbxJg5dr36mC6mXLrJxXqrqx" +
                                                   "gwFi0O9rrl+ar4SB+3JVWpc/L9P3BtVTVTvJi8No/qewR3em88uOt24NInjP" +
                                                   "TXcQD7azyGLbKV+xPtVMmd//3Cu/cvueQVxzaNDV8+ov3lx9dOvWZdU/dzaa" +
                                                   "K6EOIokGUx+s+Y0fUj/OfdN3vv+pQZvy42sGhp5Bn7+p2/c9wnJomcPar1hv" +
                                                   "/o7//D9/+tOfzO5reT16/hHje3Tm2Xjef5PCMrMce3BO95f/2jvmz7zyc598" +
                                                   "/vZZE14/UFabg9YMBv6+m3s8ZEQv3XVIZ67c5kdvcLMyMePz0F0v8mztl9nx" +
                                                   "fs+F9W+4tN/0h8Pv1vD9v/N31rdzx7kevA59ret37il7Pcqk//Dt3//RP2nl" +
                                                   "+CgMkR8eQx8Zo/mVnpzFeYOFF2/79Wr+o//2X/wucvtM+l3H/OYHPLjq1C89" +
                                                   "4AzOi73xYvZvua8dWuk4A9xv/pD8V3/gi9/xsYtqDBAfeNyGz5/LM2PMgSFZ" +
                                                   "+Rd/ufiNL/z7z/z67fvqVI+ezptDHFgXzN8zLPTB+1sNfiIefNWASfX8Jk0y" +
                                                   "O3AD8xA7Z9X8P2/+avhn/sv3PHelX/HQcyWtcvThP3qB+/1fMR1966984x+8" +
                                                   "77LMLet8Tt1nx32wK+f35fdXpsrSPJ3x6P7Cr733r/2S+aODGx1cVxX0zsUb" +
                                                   "3bq2ljNSbx20YxDTi+cTadDlILWC3IwvBH/4AvA1lxI4K9Jl2ugyBp2Ld3eX" +
                                                   "sbdd+p+tHj0j2PNhe98uDPCzP/Iu+s//3oWe+3ZxXuNd3aO+QzcfMNnxTyb/" +
                                                   "4/b7n/6nt0fPGKPnLue8mda6GTdngRvDSV3R15386MseGn/41L06Yl66Z/fv" +
                                                   "uWmTD2x70yLv+6yhfYY+t5950AgHRrzlzCTgqnEbu67ffR59Lj+Xb+lujS6N" +
                                                   "yWXKV17K95+Lr76Sy7n5wSuVq0evz0rPTIPBRO+K600XVynd7b4yqnM5vofC" +
                                                   "G88ofGT43jZs/enrunkMCl//KijUo2fyMmgHR9HdW/Qi/DdcL1Zf18kDiw58" +
                                                   "NuM4sy5hW6UHVTBo82O0YtCyZDDh9jpycL7zU9/1hy9+z6duPxBefeCRCOfB" +
                                                   "OVch1oVDz17Y1A27fNWTdrnMYH/npz/5j/72J7/jKvx468PBApM2yU/96//7" +
                                                   "qy/+0G99/jHn0zOHLIsdM31Vbn/18L1jYMjPXdefeQy3V1fcPhff8Chbz7P+" +
                                                   "5nX9Iw+x9U0DbmpzSIKqOnP2MnV2Tfi5mtejp4ZA9VVxQ4fvncOq//26/ueP" +
                                                   "wU19Im7nWZ+/rn/xIdzeUD2A2KOh5cUVXcn5v332C7/3a1/23s9dTsXXHIZT" +
                                                   "5WI9N2PyR0PuhyLpi9Rf/zB9X3ON2W8/jr67ZvPsxWxkM7+2JOCGIxyfC+Mu" +
                                                   "O77x8YZx+2Kb9eAVgvTaSw42+nTspN5VuCefi313b4fbV9PuInHlpC++lo6z" +
                                                   "1Dn7+7tjV0FOkL147/ozDHaP4FqOvvIGj4ULe+67yp8QPvv5+Qet7789euqe" +
                                                   "l3vkvvLwpJce9m3Pls5w3Uq1hzzcV1wx6ELgufiqJxwPyRPGLiFyNPDQOnPg" +
                                                   "LvXP3efMlYfuXlWdoeF792j01MvXNfEYda6eqM7nWfh1DT2szg94sPuoDefj" +
                                                   "xUkszMoXzPwBzK6s8NbgMF+LvIi+iJz/94/Xnaeudefp6nIDPv8z72rQO8LY" +
                                                   "ev5ukKYPGjrs//yw7WO4c3VrfAwKg2a86T4Ynw1Xy+/+T9/3q9/7gS8M/owb" +
                                                   "vbY9n4WD43tgLbE5372//bM/8N43fOq3vvsS+Qwq9vHvq4J/eF71287FNw/3" +
                                                   "0jN2ataUlsObVS1cQhXHvofgDV/0mkGuj0OwvjNaoNWSuvvjYYtG/I1imA0e" +
                                                   "UTStzBx/Yc2odbekMi+b+pulIiwZxks8JdQcWyQits9JCYFb/0jP0Eyecqds" +
                                                   "NQmCqilm3nK1CiUEBTbiWnGXx77JJl7Z8AVelQU6rwm3aEM4jHUS3iJAvTxW" +
                                                   "WNuq5K5uUl3SDaRPYSld1GM8zHlJyTJhZ+7h2MjKaJIrUkSWRayrvl+UsCOU" +
                                                   "LDkP/MaTSfxoNuCYxiTmeDKhdKcpoWVx66RWCijWueQET9RQ3CWFkpLaKt6p" +
                                                   "MZ/ABVGyWd/LXLHxZzqDmsamVBnzoCoqlGRJq23MZaIKsx2rzyV9dUB0jpaK" +
                                                   "CFd9rPSbuIhsI45VVU1qww70IbhcNfPlPmaFJo5zoQkUbdCg7QYWkrmOiRKB" +
                                                   "lR2mz0Ud255IUj9O3FPoq9xW6jFADL1oJhwQ89AZB9ex04WsINxyr0E5POXg" +
                                                   "POEKaJ2Re5sHYE5sym1eZlh2MiojMIuTQzJFZhadpG3j1Y6t2RVQcMO1+ABx" +
                                                   "mRbksVRYBg3bsxDX6a7GWAkKMDqBDV900rnCraQkLVfzCGuiyWG+J820j+Au" +
                                                   "t6OjuiMX/LxDY30qGQYrd2aSJLmamTkLbQs03gcU71lLZw8yrUnpq6R2ik2K" +
                                                   "GNpOX614lSLnphmcGg4rlxNhsomTJNX7tDSnFCOfqgBaTFVf4ayy3xYzdV8y" +
                                                   "TrmrWBPR2fVmytGHnIONmRYrvHdc142r9LawgGZmpVmd6OMLUQgt0wdhKIM0" +
                                                   "emquFma+OmwUVol9EZnrW3ILhCRpG956Wybuhkt1wIbaFus6opymM5yaeCcd" +
                                                   "Nv1iV+jzfnko6spyy/UpX+XN5jiIej6tSiSc9tMd0brxwoqK7QKu+5Q+wXyJ" +
                                                   "HQR+h3cevpaLfDxXd5B+ypCMQDZ5B9NNUZ9MuOGyiQKNs5VGK6ua0zVrXRCL" +
                                                   "AdCUZVjPacPcwNpmPDdjU9FSpjrVu07odIUZb6bLqgh7uAjUg+NEaGl4FWGr" +
                                                   "G265aKF0DcQgCxZgAjhIAqiqtLWq3faUFZty1eneZIsCyRbWiyNT7ThcHcyn" +
                                                   "LkzhoBbzVTbbm0aYJNA02kBxnwFiTM928yLKWt839zuySibx3izq3FVqogX8" +
                                                   "cI3uDYLQM2WqH5WZQllqjlu9jpIKJzJKq1mASQC7xo9duo7YI63PK6q11Uir" +
                                                   "ON+YlrueMvNYLaJmt2lWqTaBDdUm54Q6QZ1kIysx2yvBOtsUGQ5JorXqjuIm" +
                                                   "0yRh44fAhEw5tTctKfUnyUJtcghXkxU0XjkJutWrToWItJjJudlZ9aB9rmpO" +
                                                   "kQgp9+18vTE3x9NRsg7JBogMOlnQBiXmNdWyHryGK4QmNw7gbsN+XkOdYggb" +
                                                   "oD8xabes3JWa+fna0bfyxujLqoO2m64rnF0sWFw+zsaTaSgA6fJIVSJDtsft" +
                                                   "osAwTfd5DskJroT0VaX6sLPVZV6McxU4BvHUlTUKg7GNetxueXsGpuKGgIFp" +
                                                   "nZ7UyFUSZy0h9EqkyhROdsiCz2qXALhNT4ee0NrMeGmbuYGnS/O4Oq6RjdBO" +
                                                   "oS2/KfLVBIcRB4DqBJ00bUf5yrwRolDfz+YRayvGYKNKsEsdD3eQGT4mcQHo" +
                                                   "qb5QeqPMujLa4DjD0pKVpt649R1TLCNehYUNBhaixG0Ie9GMqw0PTaBJOK9V" +
                                                   "XTDRU+mBgktDhuAARDNPvePC0ks657KA64CDpwuANTUMYPCsyBGeiQWTaYtC" +
                                                   "6rmu6Dl5bGmhrK22m9im5bBq3fmiXLjJhietdDPrSnPl6/YcYgyG1Uxl2oMO" +
                                                   "0/P+wtEGr7q2OsOFmv1cgky+i+RwmkEsu0YUMAZEnqm3fYtSpAHJh4yfq3Gx" +
                                                   "USJ25s6M3f5AsEdUwhoyKWRR2TVWjg3Opl9Lx9kBBzXFWOx1bK6wk5XNCspm" +
                                                   "iZVq5JvHYuXKIq5tDe602qJj37GF/ZHU0o27MChdXKmK30kVc4xxarkj8Fxd" +
                                                   "GV6TYLtN4aWxUGQzj86RPWwGgmBmhW3X/SQO8Xxs5h5feVa07POMnfrhLijU" +
                                                   "kDkEcVph1JgW5FWXLLbMRNNspgZVHDdTpyUjNCIQ9ohDm7YuNQ4+EEWyWB0R" +
                                                   "koIokfKzVN0WXgELVm9pBtOS5SQsyyM8JYA9ZBYlFCyJraT6IabwZkzNhMRd" +
                                                   "ysOprlj77tgPR8jS5YfjodBcC7RnCjmu0yVn2HRGUUfFCS1vjCuUnfs7p6nk" +
                                                   "WmsiXx7Hg3NicQuEwNDvO/io6Y2wjpiyzg52PdFJMOVk8iQeccMXmILyNtCa" +
                                                   "pvRlji+ArACPKyG0z75t2io4TkAzfCeAexLSLZUOpUV9QnB4EXhmg+UFO03c" +
                                                   "Xg/mhxW8Gzu7tYEGHr6JSxKZiRgNk+OVUsEqsz1SQXVyN8sJBC8oqsrRmjk5" +
                                                   "FaJpMFvbmxDu4VnLn1JyAuoLnpIO+02QdrOY9myK6G3ypFG9QzT4YY7GC9aP" +
                                                   "y3DeFFg591eVJ5DknCdEEaL605RZIIKeoTtpkbnBFKiQVrOb+VQam8jBxzFg" +
                                                   "325xDatsUEQ37EocZyVQY6TX0YkozLDESisVhEu65rTeYUJQNOC1mWQrtV5I" +
                                                   "5CL2HX8/eDfMn8oCu+bUjkipZdBIrQSK7aQO13tKcreRgtaBTu8yn4pK/lB4" +
                                                   "FEDmbs9xPGYbmd7QAj1rZknKYPvFertAjLKs5rrRwyu9qJgxRJHusAwZoMqC" +
                                                   "Yde54JoylMgzHiGHs0wBBDgU+KxITY6JwNmCxWR2HM+nKlBxNUTiOMTzpTlZ" +
                                                   "8U5YqGyQS2KhZ12fLmhdjsTaEdDd2m9RDpCNNehvUo8c+/3e9zyQj7brKC8E" +
                                                   "X1rHMJsdFkwujUt6u2mmU5GUNGLazgkfbVr1UBbFdh9nNoMi4EwwnHAFK/7B" +
                                                   "myNuta0R5+DYY5JVmwkPFDNDlBMSptZlKXS1aQPgeln2uXVY+YLTdPT6wNHL" +
                                                   "0p5yQdwY8dTJ8Y06P0nehD1Kkr05trKyb2g0yibgVipS6mA1dc8xJgS3AFjG" +
                                                   "20yJbLKHKk5po4wJUA7J5vF4XcPizJm789Msj4GVsTOkcKxlTuGS+QSLa3yB" +
                                                   "SymMsjQrUYPvUHeLKsRQbBVvMW+1285xBzBn8X4wVnTWbtc9L9Lm2NgzMxNn" +
                                                   "FqJ3nOvValdE4BGkF8iRCmdErJ94yT7ykmU2wmaWIqo04cB8h4YAeESAAc3M" +
                                                   "406medTdeONWxi5ReY+cifuD2+lTu46XLmxhyFJUywOOjDFyKdaoYY97NXRn" +
                                                   "VXzwy13D1zPLQzIzUtYryFcAl52ZGG5V2z1JgA3ZGpVkdXwOe64LDEE7VFeD" +
                                                   "n05OfQMXKMmaGNVz2TyvzEZZOE5ThlV/CMPJgKaHhdNVlh3lQ2euCp93svVM" +
                                                   "rCJJXh8yLlpOTpKl490q9qAcEwk2gcU1R0NLQj4Md+Ie0ep0sKxJYq4XfAOX" +
                                                   "vOww6GnfjGG3XmQLODqmUNsN1+qt6eSnXUNgYBStBL7SjsWuy/tiz7e8NBM0" +
                                                   "boI4aZceThsHnkhoO/YqaN2LdMWpSI6KmKDsTosscXgCEDLOBcreDZsTuYOJ" +
                                                   "jJdWFt+42Lxe4LjFTwoc3oC7sFbH+mYIF07xaYPT08gzEa5eMtx4HxCO7dBH" +
                                                   "CCXWB3IBI/LSazCmqNjFDp0UqiWwkX88JhmcgscI7F2uYriI6BJmeio7Ql7L" +
                                                   "O1nmQd5DLQdeHkooG9dJwlDcXNlPhnBkga1hfkz7G8Y4tkeC78eOPF177Ibf" +
                                                   "Uabiyjbq78c06VFmgu4qATf09XQreaEJLhFP91Fq13YK5HY8GHQEs1yzKZ/R" +
                                                   "9YT1ADuWuJBeTksgaKxWRaZHYUot1vJG7TGwR1cziqYO0y2Dwym+Gk8VWoim" +
                                                   "jEVmCw90uqkwXa46ZCqBxKKfQeu1SwcUtYrnhF2CfCGsKIHNtobgTve8J8iH" +
                                                   "gIHc0Aeh4SqRqwZH9Ysttw7JWj4sedeFSiVvt4g7cyg/xGFuSSxAJQR4ktIA" +
                                                   "hj3VzTwAx/wO3YDuZIZBIoBH9jzfzKaHWYDaNBgKbg8zUlg4B/bohfwCTgb0" +
                                                   "qFSaE2haG8u544US7c361DWWhDUTxgtrg4NdK86WKQcwHD3TlyKGH+xYpxbL" +
                                                   "uZqXRA1T2OLIt84M97VtdVw61gFGloQyKTctWSeryax0RXlb8m2RLea22mUr" +
                                                   "nFWy1NznSohb8ErBG3gmGQLfS8uDYE/Ga1tiSw8Vi3kyBPT7UHc0Fq0qettx" +
                                                   "KCuqB7BxVfBYY7ukUTsXXO6x3OSG+xggpzJ4hEOdwXYr4jBz7Vh1l+lC1DBx" +
                                                   "iM9x7dD0lZOs5m7VrWiMQbcLZlu5jCSYuCuxTLfbOU6N9kaRNvOCWyzK0j8u" +
                                                   "fTlutekREnnNQTWvjVdVfCSY/XClg0tHcgB7iBSQFtDgxXTVcHLc7faxvkoD" +
                                                   "dF0WJq+muikuwmqPRuKkX9Oxp/n7SN/CYJOqY77ZcQfngA53tT1lUSSMok26" +
                                                   "kQGvU4RIh6RgiZpNpsmqxh8Zj1oNAWs4TqPT4MG71rMcn2PWTHrk0SPhSb1M" +
                                                   "1WlLciSd+Kid4uy07ygBz/u+A3culWf6nNbweUgXIeln/QqDxWRMaKSxGQMT" +
                                                   "VXImYLDZUAou2Nh4ySsUScfSZuMs7FPlC6djGm+snbyy5RXEVhiW1UnMEMya" +
                                                   "3HMc1RgTvvbQ8Wa5zwYB+jQGLvUQrukNoHm02HrVYq7MYUvrVePQrqz9jEy6" +
                                                   "U8CbAjKpKjc9tF7TShKId064O8ZzoUKNXXTCxMnOJ7wDHPjuGuoqIhKwKafM" +
                                                   "gdWGtxTB4AqdlQNm2x6kcKl2IXTKgk0woaxmxyI9ahLjsoyW1RFokQOeHLNG" +
                                                   "JXOzbRVdzdS12jQRfiAC0cwIm9+2k5NdNLIh5xgiAOKi2e8A+XAgqd16t1wd" +
                                                   "SmOpEbukpofzVbBN0g0oZeK6LaiTyLzvzM3cUoBDCEtgNdyrxz3QB0sLgA9u" +
                                                   "uFgo+KwjFicL4P11SIV2ckhBFmpTTUiakBWsphO1IURiaVJpdlYpYADcVEGf" +
                                                   "aYkQKBHj5HtNyshpKbHpZB27BV16iEp4hbmWVsM5xQBFFxuxwEWCv05PRDIl" +
                                                   "wy2o+uNkOBLJ4fJBDtc2jM1h7IRN4QPsSvuF0CDsGi9Qqt+bQbiaLlYFEZhc" +
                                                   "qKTHOZFtZyFJVUy2GnxN2rfJEROwBbudxbyzm0zGGNzVyLRDBxdQMHgIbNY7" +
                                                   "0YCInVhZ65g2DTD2E5EeM2ANnJo45ndFuS0NITS2NcTK/Img/c70hpBQtEys" +
                                                   "GwJrkejSRO8nDIGHvr8tsGg+z2YbROuHI0hcRdKklxfRbIenSEPzQp8YaQgb" +
                                                   "q6mjzrmVoXvahsFPcwnjqSQbDudma/cWi1L6GGVo0NvVXca3Nri0sMSEfJYa" +
                                                   "bjqExa9m8px217spklK65rPSXiDhQIF9XzwE+6VNUWXtZFuWlinmgPIBNBXX" +
                                                   "NSrHloiYHQnb8QICPS9hGKxXXQzWm7CaHc1g7lScZWwWjRPSmZdm4TIp+jFz" +
                                                   "aMNgt9sHWGVlq77fE/YBkzzLzpS1tZqV");
    public static final String jlc$ClassType$jl$1 = ("UyQGUkhLk55fBPRif/Jqm67ieMxtYX0OZuYEFAq6tRi/Z3zY5YguAnYuNHFg" +
                                                     "xFcp46Sl4oCavIF1Y6pDoZ6SjsOZwmCqW6UUUsM7FBMGqbt0Iu0lcDxpakEH" +
                                                     "CDa1VrTPbsdj6IjCNu4lCl8hAOfy+s479GNyTK6Nkg2j3S4zkiabcw2IHwa3" +
                                                     "CJuTLgFO6xIoUy5fVbKsRX5ZHvqKA7pTtQH0OrSPXK17Eq8VG7ftECGYLBdQ" +
                                                     "vESotiAZdceBWBvJqBdYjQ3Z9azUaKlrI01Ej+MNsQB4JUichQ9tYwGWRZkO" +
                                                     "bchFkLI71kV4oqRe8wvqsLPT4w5JuCKPvSQ1Fa0Km4Qu3bA9cDG/nMBNH7Nw" +
                                                     "Bal2b4uQF9Z1U+TGsp0fSJtChappoO1GnwlNFogcTfHe1K78oFxnge5btmtK" +
                                                     "y5MFr1N3s2WUHBZbXZXkVTCFipin8n1Y8sMfLKaj5cIneCb0N85y6ZNMvCSD" +
                                                     "FZRCc0ZOawKUuxRHK+3UyZPA0w5g4ZWDXAGiiTj/dMyIVDgdJJJa8z2yClQw" +
                                                     "t6VgNWVxLZ3X27CBJ3AusE3HlTl+RNLF4JcR/ISZJt6D1h7ZDafzocgZBzoc" +
                                                     "A9aeD3deLfa7GE8ID4vxIWSyOFJASSrH3AiFnC25wj0i58qViQK7jRtb6eBY" +
                                                     "7LKoTusI2Kd2dkRmXeTILtnm9nCBjxDfyfOKDRA2rng+B0BinttdbwTL1hp4" +
                                                     "6FKJTmyRDiRtq9zhEoRNj6eMkPZHyz4VVecTXIgwYGQF8hxq1/m4MLYHel7A" +
                                                     "vV3khO/xHAt4x+FSOtuC47W7MnpH0Iyl0qYeQIExoQD5jKAMfhdI2mqP1ani" +
                                                     "mbvQbgtBLqdxS47VIxtb0yPeLkJT4PJ+Xmk9OFzzOwV28mnJmUdgPbgoqoLD" +
                                                     "LTYEb460lA5kaKBrBLORwF5G3m6Nebzko+WGKMPE2Kh4ylW5SS8rZWfUVAb3" +
                                                     "E13DZhPn0M0ZZ9/l7CZs0DZOhrsgFR+rGdJuaU4kItnIdQEUuVyB5PWqkU+z" +
                                                     "rKEW83U4p3e0oBxb4DQ1RdCgNqhMgN10vTv43nq5xjcVPPgMZPAZVCCI0RBr" +
                                                     "cFSyQmXQCPwlNNkGFL1RwwlCt9HaMCvBy4wFy6HlvM4TCJiFNF9OC4LO4bUi" +
                                                     "sePjAVzNVRTNDWs/n0TYcUYf3AMkY24thgYn9ctxG0o9f7T3R6H1TihrUnYs" +
                                                     "yOHETqFUmTMnnPXEoKWMcbPoYgJCTvMDagbJcQUM7AAP0TSCmlXGT2QZlhli" +
                                                     "mMXMVKWV47E1NheJ5c64o2TUGkK4/RbSBJ+bQLQ53D0lbMxgXdZRmaQwu7ZS" +
                                                     "KXGHQ3ibefBuHi8Sie29bC+xZmEHsy1BLfS9B0wisgzRtb3dRW5JUJRtzIjI" +
                                                     "mqfACsUk7MRjg0+t4810ahkUYXiOlTBLPEebzuZYVJ5YAlY6HNags7m1kr1l" +
                                                     "PkR3E4BcR3sdpbnBlnJroorjBgotbl3hybj2wdPE2By1POni8aFnrBwpxx0Q" +
                                                     "NusYEDR/PvPCsQRMVsdjIKaEzdbDFYvMEgqfCkyga0nrmoCwiuijQRQmKRKi" +
                                                     "5TXbrcWZCprx4JKH2eVWcmRkuRBxgc8jd++wvTNFesPwk3mPaQ60ndZIShtE" +
                                                     "fVoeIqnUnYJO/Z4PtN121tMTsqhUGrbYMY3NyekAk64nVs4CUh74RR12tYhq" +
                                                     "2w3BEvb8RAxOW9YSfMUwRy0yuj61e1k4KLRfMwXN6PMhpl9Dp8KjstgKzJaO" +
                                                     "1qrfdIPjtIbYBlqPk9AYc1BHCgBvQTwkrsYMSakn/3RgHSMEyEm6zoEdgZyc" +
                                                     "JYsgLn3ESI9WVzkuDyglogKGfk1h6SKze2Tce/MKSIMobIRO3E/52peMUBIU" +
                                                     "bbLo9Vrm28QwEEmUsz4RxRNe2xC4dHSRn5nTibyYOqCY1qYbLCkxIqdWSXLT" +
                                                     "ZL3PC2oHTLI44G1p6vVTwqvjqSySg3+oyNxod/iG0bx6OHJoCJxag3477Tbi" +
                                                     "67kfD2fUDok0HTsUsxgnRKeVij2gTUDMAfkhNHWWRmPbR03s02Y/hP0JD4d7" +
                                                     "QnV0d6HsiMERNoq3bwNhyRZR4UgIf75bejk03C351VpgTh4YriNn6bTjGWJw" +
                                                     "gQ2ZrYARsMUNR7q7OAAAoyQYiewF3FtMuIndrNmZ5auiJMkVyNZLudRRf0Y2" +
                                                     "FTgGGnZXiQ3VQkvKd+wyP4UyOokjRSfQbTVu+cUJPeq2jyyVIoBtkGh2IK66" +
                                                     "BY+vGossrTBapmi/Y1CWtuodNzub505uEc41xrNMNTyI6LkalK3FRLHjKIYw" +
                                                     "OrNwxAkIlDFCrqeBg25AWCoD7mnf7hGKDwCjn0Wxo6C7A60uaEmcFSHnNEPU" +
                                                     "wm6pMBor4iRjxoQvj7OsDpkZiB0s5YAJnuDSotFzDeY7FhLMeH5iTMh+XvjW" +
                                                     "dJHW3CKdQ6pBKlzkx1pK1BkyKChtsPt04Guy5NKYFKbOjF+zClUziRazaeCL" +
                                                     "tWjYQ5AHc8iShr2sBY8lJ3ZJRdsYGQLdYjmx3MN6y21Pp2O8O7K6vWHSrDpA" +
                                                     "grvfe3PVDY+tzTHz2XCgH2cVuqoiY4/xjs4t174FQ4dKgoyDLYeImwZIIp+K" +
                                                     "fgpY1IQwfM/XC61iRW2x0OXhWuFFPoGG8860E3Vt1D2RBWFLKpqM9xDQr2ec" +
                                                     "rJ1AoW9FnRqCeURn+jhKJlsnw6Le1fH5SafQBqgOJ60Zw11ja319qmJWYkEz" +
                                                     "HytsGcfISt/1iYCLfXViKYyYCRJagM6Ria3IARa1GMgypCOHE1IJyaxEM7lS" +
                                                     "j/3gPhQY0ywE0UnVDpGUi8UiQs0VbpWJzvd1nEqAqpXTfgujbTUDjjEmtwzF" +
                                                     "IZjXGDawx5Opk0XeJCHzNEln6V4D5R2i8cNR1ZtrCpqXiGtkez7ZpmN1vBEh" +
                                                     "lUg0rCBJgt6Dbr+YDfpBI1a2qLPJgVgU/MQ54T2J5EGz1s3Gg1R8YDdQn5Bw" +
                                                     "j7rothBCEc03eA0ooNP0uVSXfdWdyJ1laJhg5JEiKztHJ5ZkSELdoUlhrgxo" +
                                                     "NDUnGL7fIe0JnON8DMF7mCk0k1G8CUhsY3s44Cz9nArwXddZBW+55DzcS5sP" +
                                                     "A/c88K2PTa74OlxUD8jeFbabvRF2OkgQCxZOkZlYDjFoXhYtB8r1GNyr7W6G" +
                                                     "By3Anwx2TIxRzaOo8zJ/+XrTL39k0+fhV9n2KpHk+56QCEQ9lMPx7vNil6TY" +
                                                     "m3mwr0hnkI9ctujuJ6Z84F5iyuX39HVa+A9e13/lgcSUB/IsR+dkt/e+Wgb/" +
                                                     "JdHtM9/2qR+zpb8F377OuFnUo9fXWf6R2Gmd+IGlrnIWg3tovOFulvrwPfWJ" +
                                                     "6zp4MLvmPpduUHDB7NnrKf51fbhJweMTgv76E8Z+/Fz8cD16+5mxz99k7PP3" +
                                                     "8blBxZ3hI0ajZ952XY++NCqGKU//4XX9v16dilv3EzY/dln1J55Ayt85F5+p" +
                                                     "R8/5ZmrHzgMJfY/LoWmzwH4cYeDwrQckf+G6/tEvjbDzlB+5rj/9xxPPzzxh" +
                                                     "7GfPxd+tR2/ynPoGQfvHYX/OktwP7b90XZdfGvbnKcV1HX0JYvknTyDh58/F" +
                                                     "PxjEcibBueB/lRZ17pdvEHEvsdYc2tF1zT2BiMckn52nLK/r6ZdAxC89gYjP" +
                                                     "n4tfrEfvOGf7Da4gcE9/JC0Xgbx/+L5tNHruI9f12780gZynvO26fvMfT53+" +
                                                     "5RPGfu1c/Eo9emvulOfHD9T9ZLzzyE+9mkp972j0ln98Xf/4l0bBecrfuK5/" +
                                                     "+I9HwW88YezfnYtfr0dvq5yaeiQZ+nFEXJ4GffAs6tHV71LXo9949M3GnRf+" +
                                                     "lJ9sfOijd4rGrIKiyWrnhau3EHfOnunO+awL0jaLnJnjPvBS5oUP3flE7QfV" +
                                                     "i4/31y986KVPfijPX10ul9/TN7lxHv1Cnj+B7//xCWO/fS5+sx6989WQfpxY" +
                                                     "zifwJZX/hlj+3p89sVwl6j8ol6A+y+HOxz6u3nkcu7/hYXY/8zh2/+4T2f3F" +
                                                     "J4z913PxO/XodXdxeRx7L5u/9xH23vqFP3PsvcrWvXOt/NfPAC58vps8nbkv" +
                                                     "fOySD37u/YSZHD55ya69at17UnP5e5knffjONbjZmjfhr5Kfr4Czj7ODGAP3" +
                                                     "zgvZneDeZnduYn8W9c2+O9adr7/zwiOQ2Ut3rlK77zz65mdzznB2imbQpnhg" +
                                                     "rZa9YL34hJD2wxdSBnu+XtA148p5xLofn0B/Lr7l+lHVw4p0+z7UJV4uLlB/" +
                                                     "8AR1u4Rnvz+EIA+L5NzLPqh0d1/DvfOust3tOI++908A61ujV8f61gX2f9ej" +
                                                     "9104bFb149l8wakbgpObA+cXX+985On11QNh63M/9ubXvePHNv/m6qXF3Ue8" +
                                                     "T/Oj17lNHD/4humB9tN56bjBhbynr140XVhy6+khGD3jdm4/k19R9/8BEChm" +
                                                     "oPw9AAA=");
}
