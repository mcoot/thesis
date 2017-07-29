package conf;

import jif.util.HashMap;

/**
 * A system to handle the submission, approval and session allocation of papers
 to a conference
 */
public class ConferenceSystem {
    public Organiser organiser;
    public jif.lang.Label AL;
    private boolean allocationsVisible;
    private int numSubmissions;
    private Paper[] submissions;
    private HashMap allocations;
    
    public ConferenceSystem conf$ConferenceSystem$() {
        this.jif$init();
        {
            this.organiser = new Organiser().conf$Organiser$("TheOrganiser");
            this.submissions = (new Paper[5]);
            this.numSubmissions = 0;
            this.allocations = new HashMap(this.AL,
                                           this.AL).jif$util$HashMap$();
        }
        return this;
    }
    
    /**
     * Upgrade a paper's policy such that its authors may only be viewed under
     the double-blind conditions
     */
    public void handleSubmission(final Paper paper) {
        try {
            if (!this.allocationsVisible) {
                this.submissions[this.numSubmissions] = paper;
                this.numSubmissions++;
                if (this.numSubmissions >= this.submissions.length) {
                    Paper[] newSubmissions = new Paper[this.numSubmissions * 2];
                    for (int i = 0; i < this.submissions.length; ++i) {
                        newSubmissions[i] = this.submissions[i];
                    }
                    this.submissions = newSubmissions;
                }
            }
        }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        catch (final NegativeArraySizeException ex) {  }
        catch (final NullPointerException ex) {  }
    }
    
    public Paper[] getSubmissions() {
        try { return (Paper[]) this.submissions.clone(); }
        catch (final NullPointerException ex) { return new Paper[2]; }
    }
    
    public int getSessionNumber(final Paper paper) {
        if (this.allocationsVisible) {
            int result;
            try {
                jif.lang.JifInteger sNo =
                  jif.lang.JifInteger.jif$cast$jif_lang_JifInteger(
                                        this.AL, this.allocations.get(paper));
                int toDowngrade = sNo.intValue();
            }
            catch (final NullPointerException ex) {  }
            catch (final ClassCastException ex) {  }
            return -1;
        } else {
            return -1;
        }
    }
    
    public void performAllocations() {
        try {
            for (int i = 0; i < this.numSubmissions; ++i) {
                this.allocations.put(
                                   this.submissions[i],
                                   new jif.lang.JifInteger(
                                     this.AL).jif$lang$JifInteger$(i));
            }
        }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        catch (final NullPointerException ex) {  }
    }
    
    public void setAllocationsVisible() { this.allocationsVisible = true; }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1501306864436L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAL1cC3gVRZau2wkJ4RnCK0AIlxCQoCTISyEwEAMRmAARkigB" +
       "DJ2+fZOGvrdvuvtCQPFzdBQVZVdFhU9hZQZ8LYLOqjg6ug4+gMHRAZ2RcVd8" +
       "7DcuM4qvcUf9ZtCtc6r63bkEd2bzfbeqb3WdU1Xn/OfUqcfN3tOkm6GT4auV" +
       "eLm5PiUb5QuUeJ2oG3KsTlPX19OiZumbXa/Gti1LvSuQnCbSXTEakoYYl2tJ" +
       "npg22zRdMdebJL92tbhWrEibilpRqxhmZS3pKWlJw9RFJWka7eQaEqkl+Qot" +
       "EZOmIppyrEbXEiYZWZuiDbWqmlkhd5gVKVEXExXYlYq6alU0DMopB0stJt1T" +
       "urZWicm6SUbU0o7z2qrYIqsVdfxdLXyr7NBJ1GLPx8cGh5zZ6O46v2LrPVfm" +
       "/yyL9G0ifZXkUlM0FalaS5q0P02kV0JOtMi6URWLybEm0i8py7Glsq6IqrKB" +
       "VtSSTaTAUFqTopnWZWOJbGjqWqhYYKRTtIvQplVYS3oxkaQlU9Ot4eTEFVmN" +
       "Wd+6xVWx1TDJIEcsbHg1UE5l0YOKU9bjoiRbJNlrlGQMZOGjsMdY+kNagZLm" +
       "JmSqL7up7KRIC0gB05wqJlsrlpq6kmylVbtpaRMEPLRTppWgCFFaI7bKzSYp" +
       "9NerY69orTwUBJCYZKC/GnKiWhrq05JLP6cXzdhyVXJeUsA+x2RJhf53p0TF" +
       "PqIlclzW5aQkM8Je42rvFgc9d5NACK080FeZ1Tlw9eezLyh+4TCrMyykzuKW" +
       "1bJkNku7W/ocK6oum5bFIKgZCijfM3IEfx1/U9mRooY1yOYIL8utly8seWXZ" +
       "tY/IHwmkx3ySI2lqOkFx1E/SEilFlfVL5aSsg4nMJ3lyMlaN7+eTXPpcqyRl" +
       "Vro4Hjdkcz7JVrEoR8PvVERxygJElEuflWRcs55TotmGzx0pQkgu/ZDh9NOd" +
       "fvbxfJtJVs2dvqLBkPUaysVYMUeT0gmZGvCKhqSywmyTDcVYIYmG3GyY6ZhC" +
       "a1BEc6njYzM1yBWGLuGXFdX2y6XrDVNOlNO3qf+HNjpgnPnrIhGqgiK/A1Cp" +
       "7czTVOokmqWt6Uvmfr6v+ahgGwSXEMUqcC/3cyeRCHIdAEbDlEpVsoYaN3V6" +
       "vcqWrlyw6qaSLIqm1LpsKlCoWuJxrtWOB5iPzlCiMHxjVmrVlinDZgikWxN1" +
       "ksYcOS6mVbOu+hItnaTOZIBdtESmfiaJ3i3Uw+amJKQxyeCAb2Q+kZLpDhMg" +
       "G0ahX+o3wLBu9t106i/7796oOaZoktKAhwhSgoWX+NWga5Icoz7TYT8uKj7Z" +
       "/NzGUoFkU7dBx2bSkYEXKva34bH0Sstrwli60eHFNT0hqvDKkkoPs03X1jkl" +
       "iI8++NyPaqmnZQv0k9XM84Xwtn8K0gEMT6B23yjQK89cmtpx4rU/ThKI4Djw" +
       "vq4JcalsVrqcBjDri+6hn4Oiel2Wab13ttXdedfpTcsRQrTGqLAGSyGtps6C" +
       "TotUzDccbv/9uyd3vyk4sDPpnJluURWpwx4klJMefHC1PK9xDZK2NsbpD3U6" +
       "KnV8tLtGaUMyocWUuCK2qDLg/G99R1/45Mdb8hkOVFrCpKqTC87OwCkfcgm5" +
       "9uiVXxUjm4gEk54jM6ca86T9Hc5Vui6uh350/Oj48O2HxB3UJ1M/aCgbZHRt" +
       "BGVAUGkTcPznY1rhezcRkig1Z/9L2twwx2jReGjcoLCgolka9EVJRapmznuo" +
       "7x7gJmispEg0CioK2Fy1/RYMD+buVqvy8EDl+c5rMJnB/j7w9rNXRmNfREuW" +
       "o530jMmGpCspC1jU0/cwlERKpeKWY2jeNMYwtQVUfHbApItJQ6UTDHMJ9fhy" +
       "bkdKh+l6raijnlAqozoApHY36iAOa5Yu2rxJ10bdMlXgguwDycgOGgXGmJeK" +
       "pqSoarmX6QBj5GE16wjTabpZ2jHwnl8U/OsdVWwuHuGlCNSeMaH6xubJj/8a" +
       "QQ8AKfZLa4ksUh/PxNksfbHzbXnJlG8+YUaqrUv648cUDX0kJSVCDMmfIPTU" +
       "kQuMYzbtVWEAFpz91Nvu33/6ZN1sxLJLARAgBGJUrmGX6CCt9s4Vdn/K67WU" +
       "3aVm6cpBvzm/6BfLbnaLyUfgqr3l4ftyP73gm/tx2DYMRvlgYBNkhAKk01h/" +
       "0Vd4FOTupFtPgwe+8+bhtfM+Yd314yCMYtbEAc+fKhxyFdcsNDiHtwrZvFBl" +
       "X06XIY6yo+W1B/89d8mvXMpGDVIRrMOKTJ+QVjkKWEQZjw6T5yWaaWoJl1Rn" +
       "jnp7deWZY09YBjDXlkqZd4A+Svcwc8Y9O2TLf1y72OIxnw11sWuol7GiycyH" +
       "f0f/IvTzLXzAT0EB5DSGr+aRY9QOHVMpao/d3XbYgGxmGOBYfMHLPNFoo5PP" +
       "CfWtprveGVfMdOWanPj7Z+bccNfdTx+YzOKbXrTp/FmzCWE+E5jPgqQRh7PS" +
       "GU2jZzQhRQsdshZH3422voNFLC9Ef50DQZ4nxqqBFZUTV0gbZn54x7ftNK7I" +
       "aiJ92kRjfpLOw7CAo+tEcMr2N5P0c1krejuILlR3pORfdfgaa6rYe9/Q6h98" +
       "hI7ACWKAekRHMBptFF3x1cRHEv8jlOS8LJBcGgZicEcXy42imobQoImu/Yxq" +
       "XlhLenvee9dxbNFSaQdpRf4AytWsP3xyomD6DLXhuYcvYoIPOZ89CGN53scd" +
       "MUUIPiSRpATT0ZCMRZ0J8Fhm0paVpKj6gpR8zq83zyMuvibJ0/RWManQ5YPh" +
       "mSJxhpBjbF2356G9+yp7PbwHHUAe6o9q0+TTYXegsL6zofX2Di3Kmx4eNjS3" +
       "UdL3Q8MIBrsJMOvg5gdpU6jx2ByHQeEIzqmI54X+ePRqOv7SUPcPuHV5qyIl" +
       "kd795a/qEJK9cS/FUr5JhvgB7wTt6Nm8nbI6MySsU0Zg1kaGbqd3ovbMzpm/" +
       "e/5Je9Ye4gsuHGOYeuSRrNcbV+xgKnStBtwTKiyoXDsSfCukuLMxsZ0QHNga" +
       "e2DFMLAyvgJ+huf73QMjDMubwrGcxbGcY+DOEXzTsYlGk0QWG0GPQVWToC5n" +
       "Ld+nkG/aest35Vu2Cq7NnFGB/RQ3jWsYvblb1MnITK0gRc1/79/47EMbNzH3" +
       "XuDdmpibTCce/d2ZV8u3vXckZDWcZ8PLWgoVdaI5bKrkv3I3zT+1YA+63Hxw" +
       "WxhLUL8FpohF85Peop6KYWMWh3Y7JHfCGhqnDa++/NYxLGCg7rllPTLc7sw/" +
       "64NTkrdooEn64AbAYsvb4LiJy5TbvC5jPP30pz25nOeVId7w/kzekAEn6AqB" +
       "2XSel3tcoVBVi9XTrrlxMiS7mMt58Kwuh1WG9BFHEruCwtkVlCkj238OZLe5" +
       "uvnPpmtazY/4XOoY6OIFfMyNPK8LuNQDXXep51kTFnBq4Pllfpf6LNa/xks1" +
       "ltdeEkaFVa9zuYc5NvG4sCbrA8TzXDJ9GnvxoiPAp4MytYscDTtI7GUhcSBt" +
       "60aeyyFIPByOxIhJcqml0zWC7ENiT84sxvOVHiQWiKqqSbgfbjQqhmItGtLe" +
       "ng3hxHpYz3wY6B9GoAYwcKzrGBgAhYWcUzvPE34M/NaHAaQayGsnw6gCGHB8" +
       "1eCwJlMZfdVx7MU7jsKPBzFwPJNd5bZomiqLSZfDOhYGk9Gsf8KjPN8aApM/" +
       "MJhAcjSIB6C6k+e3evDQh84mS9MtCcUwABJhWBjICXeENe/DQt8wgnsCWPi4" +
       "61gAx4qqBU738XybHwuf+bCAVFyvwvYwqgxY6B/W5L0ZsXAae/G1o/jTQSyc" +
       "zoSFLCVpunDwcRgOJjCICid5/kwQBxGSEQdA9XOe/8yDg55GZhCM4lTHwtr2" +
       "gWB4GMFRPwgiuV0HAUYSJZzTb3j+qg8EkZ4+ENjxB9T+dRhVBhCMDGvy9Uwg" +
       "iHTHXvS3NU4L/CBwFelkqBOY4WoRt0tZqHloUuFdm+78ajCNqZtILl9N4rpy" +
       "kZbELyFncS76z/a++9Hx3sP34c5jdotosMWh/xAzeEbpOXpEUPfyAmG4pc9O" +
       "geBDzjBe8UgXkDMwjODFAHKKu46cQVA4lHM6zPOX/Mgp8SEHqQbz2i+HUWVA" +
       "zpCwJg9lRM4I7MU4ByYjgsgZ4UKO9xoA9d+G6TqIvWJs4y9/PMTYzJYPZTZK" +
       "5A6zHBeVnNRP9/sTWRN7mqX/hAs5GzTda0k3A2qaJNr5FQDkxVY6PW1J4NFl" +
       "Af3k0M9ynteZpOHveaxYJ6ZknZ9X/mMYo3Im4qjoagPPEcrxJR4vBjTRLPWb" +
       "dm9L/LrZh3B51heFh2unpUyMY7zrYk5UutRbz3snIlR3zdKp/bcdHvmnxv54" +
       "2G2pyX2itVBMVfpPsGCTkJZ3y337ly8OWnUsiwg1pIeqibEaEQ8DSZ7ZpstG" +
       "m6bGOlLcsCLrYLEtEGuV92PvbFnKlZvg+QoQ2WQ01il8VR6ZFR7JslU5JJsh" +
       "sVfkPavw0op9+PkE8JiK1BiBPEXoZBeywTxnPV0PKxI/gnnw9RcP/HRw/Xi2" +
       "UoaT9bDDnyqJekCjjr5lEL7IHl2BFQuAER/k+QtuYzbJ9Bhrku3gRnU5RaVH" +
       "cSfHoi3roxR3Udw8i4rYShQ6QUsV6rBrYUyXBvfo3WNw78r86bHbT0166eh2" +
       "ayt6ZrgL9Jw2MKk4I8Rt0MjnBy++LRYvovNDE8lLymtlfVFaVWuJEFdCjnE9" +
       "W6dw4ICzyCLX/iO/sxCp6fDMa/7GtexplZc+O2+M4LmcAUz6Mtc+j8CX+yHZ" +
       "E6Zdh1U9lWBZYeEf5vy8fBKyEySMoPDCSedkSzTNnHK7uu/fpvxxBRdjBP3r" +
       "PCDO7+jwbtZ1bp8XVkqLDmrTyrDtHNBn6QQ8GQ2x7Uo2ODZjVaA5ZdumhHIb" +
       "ZgVwV4RbiXvngRtIjionW00WI6YZj7DzUJATN4a7/zJgyXWXf92ADp6LawTV" +
       "Q5yq3lYmMwDGzyRzGKa1OOLYSMmSQpFsnTdFS2DcJVElGUWHuPyqcRzYG1de" +
       "tfiDG+/44JY9G5evTNnnNTbCq8VkUjMDAM+RlCdPV8TP2ADHCTBSyIdnD3U4" +
       "6q0YHTMklyPmQ4+05yZSJh5Cb3h68BMzHtx5Erc0A5rwT6oLMQ5ydjkv2jWn" +
       "tOhg+5a/380P+Dos/JLHCF9k5+/Mwwv3Hrl0jHSHABcE+NFB4FqZl6jSe2DQ" +
       "g7Va7zk2KGZihrTFWUeMQbzh99Dj+Ugiwzu41BRZbZJukqol5bMrM5VKRSKE" +
       "BHixQBF7wmzJPGsMyCpD3XVYcNazKmc5x8iudtZumU7GIG3ogB2ZokxGANXO" +
       "oGiZoV+JbYD0I3GCJyds7cfXRb6131gWGGfN5nmpewriruO6jGs/oBrF8yIX" +
       "NZ1pXXtCvgg+15r+YPbfQ+zLZxdXtGkJuWK1HKtYp+lrKsDpxaiN4YOqtIyn" +
       "URQ+YxDCAw4epH1vWgcEkesZCDZ3BQS0MqRbnFD6+mB0fX0wKGdkd3adLFIB" +
       "yU1Its0KF/PBq7jDLqx5MaYzeWezMLhCN+8LrnAJO5rL/SniHHlEbkYB3GIF" +
       "Vzs6Ca7s+0X2sYfvLO9cD6tNEmm0NzAiu9FvPAmP2yHBTdWIcxZVaK2FAHUT" +
       "eT7Bjd3/c/j0EDa5oFMMRFCZDxN7riW77F1+SH7SjrGG5Y348faD7TzkJPlo" +
       "mwfsQqwauQyZ4nufynANW8RV9SjPHwhR2eOdx8ORXZBAzyI/RTjtpmL/ITw8" +
       "2KmocftzEBdxOc8v+LuK+qkuifrAP0LUWAjRGXyBvfnIvS6XubnDNV3ZEsG/" +
       "HK6Be3h+u0siWLPQuUs2vLPLzXhUtvu6rTtji/dcaMUmt5t0oaSlxqs0elZd" +
       "rLphH1vtbuClxSj9XEx7c5rnJ9yKcWDkG4F9FRBI3uL5Mf8InJnXHVY6ThwP" +
       "R6Yy6twszuVLdweMsKBdb+Vh40O9Xz56urDmMG4mCZICN+ICd0ljcmeRRjpF" +
       "J0V3xCOsVeAp4VtqTQjr5hkvgFug3YSmp9psENPQlN0jjYp6K673KW5pi/CC" +
       "bWZF28RkTJWdbe7o2BboDkW92KKtlQH79kRdxhz0Kpa1QnKYKQgej2QSOFR4" +
       "jSEUNgojeEAQeQMR+ua58QveP2lIrklq65Jsp2Zpz73p658bf8KCIj9cxvb+" +
       "M0M09h4kh+ik5JeI7dFdW9LZazUlFhaKhayveO84YAZUfLxj8dcfPGZ17yI2" +
       "6pRHtB/6Cum8hHpzJvnjbJI/h8OCC6FwCoeQwCH0rc/UIp9i/Wu8VBN57e/C" +
       "qLBq+G7f5JAmcyMBYndgwXDxlRNFBA+OXEX+O1O1NFRTnaVA/a2H3pq6/dQd" +
       "uAzNfAHKR6nuVg/Vfrn+NUtLzkULdBgz+FjywhwGjzi/DZ/CcPj2OtWlVm4i" +
       "qNV2a1PNYyw0EbLRYEL1DW9+C3UEm8e3yAjfvNU59IVchD4k70PyAQm5TYzI" +
       "s6UALhsPuGH0f7b8t1sKkAl5XYcnnimM5py+4PknPngKvX3wtE8ioPanYVQZ" +
       "4Fka1uTnmeAp4FpQGGhjkRb44ekUQdoAQSbo+LwwpbyaQSlFZ1cKihhbCZtW" +
       "4dT+MjpF3sbzwCFx5mkVSFSex12kGbo8KsM7MAGh2CR9WmWz80NV7HgRb/Wa" +
       "sI77gDgojKAjAMSyrgMRT7uHcU4beb7eD8TxPiDaZ+RQe0MYVQYgDg1r8uqM" +
       "QByHvZjioG5cEIieokihV8iDLFl1KmRwSEKla2E5iQYZhdbleBEO1KJwEGJf" +
       "zhVmnlXKjA3UrXL8+aSgi58UnBkYWU3XyNr5fgn80qkTXwbc8GyJwCUnobYr" +
       "fWcEAtPcHFaAz649E1/RQoes3lFN8AzLKerUoMFVLaPP9Tyffm4GDSTTeD6p" +
       "c4MOj5PhHhOp5NSreb7cj5nI6zbBlDCCmJvg+0as4EBk9B6L0vCr1nOLWIUm" +
       "O8IUlmcaOlRY5USsQgvqUEJ3EjsnflD1JFKrGRwk7PQLy2j86R9fmIscwAVa" +
       "HQYFn4vsE0Yw002AY9K77iLxJkt/zukSnv/Ah0Zhrc9FIlU+rz0rjCqDiywI" +
       "a7IqQOx2kQb24hrHwoyg0RluozvTyd4qhuNUz8EY3V0YiNEpYlCwN3ddsLDC" +
       "I9P56BSee+6XAcNbfYJFqot47XgYVQbBTgtrsi2jYJklbHWk2BIUrKco8jev" +
       "H6nizaTC/AgLnwV2z/Xcwmdqryjwdk/4bFkuJP+C1huqCngDQhN2WDwE3EvC" +
       "SE1ozWC5P0HLhURzutKOr3SGq7PG0+DaMWADcTRZfj5go3u6DiW8fTqOc1rG" +
       "8wY/lB72QQmpzuO1G8OoMkCpLKzJKzJC6QHsxeMObh4IQukBz8TojqcDWroy" +
       "g5ae/h5aQpljs2HzMaw7rqJ+rZ7nHp8Kaeb5GEhm8HyqizTDGF7I8O4gJM+a" +
       "pIAKB6bQKufgor1rizoYDy6KoEeN1uACIHy5S5HSK9ipI44aXwlq9pUgIBjZ" +
       "a10j61QzYE430X69y/OXz00zQPISz5/vmmZOZHj3NiRvmGSgIZtVgSvGXVTO" +
       "aMsyoVPvW+MLKOedLimHRSPvOyI9GZTyyaByGNmHXSND5cDPaf3/fQC2bQoD" +
       "/9CE/RMOad/Ovt0H72x4i13Os/5RRh4/iHf/qsv1nJPS5biCis1jv/FKYU9P" +
       "myQbbiTB8yf2TyLy8SwcfmJWzn5i1sGm/UK34MM1+Wfvr7XgKDzN/sFLs/TZ" +
       "xAvnPH94zCH+G9FObyc5FPt3Llh01edT2e+7ukmquGEDNNq9luSyGBj7AL9I" +
       "H9kpN4tXzryyv/Z5LG+059fMBS6se0ZX6Mylm0KvxHj+A02ztIZs3PzSpoIf" +
       "4ZXLPMWo19NUkzH4SZN1DAC8bmA7mikGxb9Sxuf5fyrrYuu+2xBZvX1xbe53" +
       "V2S+vMNOgv8XEWekeu9HAAA=");
    
    public ConferenceSystem(final jif.lang.Principal jif$O) {
        super();
        this.jif$conf_ConferenceSystem_O = jif$O;
    }
    
    public void jif$invokeDefConstructor() { this.conf$ConferenceSystem$(); }
    
    private void jif$init() {
        AL =
          jif.lang.LabelUtil.singleton().
            toLabel(
              jif.lang.LabelUtil.singleton(
                                   ).readerPolicy(
                                       this.jif$conf_ConferenceSystem_O,
                                       jif.lang.PrincipalUtil.topPrincipal()),
              jif.lang.LabelUtil.singleton().topInteg());
    }
    
    public static boolean jif$Instanceof(final jif.lang.Principal jif$O,
                                         final Object o) {
        if (o instanceof ConferenceSystem) {
            ConferenceSystem c = (ConferenceSystem) o;
            return jif.lang.PrincipalUtil.equivalentTo(
                                            c.jif$conf_ConferenceSystem_O,
                                            jif$O);
        }
        return false;
    }
    
    public static ConferenceSystem jif$cast$conf_ConferenceSystem(
      final jif.lang.Principal jif$O, final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$O, o)) return (ConferenceSystem) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Principal jif$conf_ConferenceSystem_O;
    public static final String jlc$CompilerVersion$jl = "2.7.1";
    public static final long jlc$SourceLastModified$jl = 1501306864436L;
    public static final String jlc$ClassType$jl =
      ("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" +
       "Y9kLTn0NTQlRN/VVHR2zGDb5goeVtbhf");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "suqPP4aVnzgXP1qNnvON1I6d+7LEbkrMaLLAvomx86q7gci/fV0nXx5j5ynx" +
       "de1+aer56cf0/cy5+KfV6M2eUz3E0Cduov6ceqcN79J1/ZEvj/rzFOy6Br8M" +
       "tfzLx7Dw8+fiZwe1nFlwLvRf5dqc29WbmHj/8HzLaPQW6br+6JfHxHnKN1zX" +
       "yJemgl95TN+/ORe/WI3eljvFOQEev5cVde75J6+lhk+PRs994br+hS+Pg/OU" +
       "n7+u/8WXxsFvPKbvN8/Fv6tGby+dCn8kK/UmJi6fh3zwrONr33mpq9HnH83b" +
       "v/3Cn2/a/osfuX2sjTI41lnlvHCVD3/7bMy3z8dDkDZZ5Cwc976PJV548fa3" +
       "VH5QvnSzi3vhxZc/+WKev7ZaLj9PPyyMc+9/yPPHiP23H9P3O+fi89Xona9F" +
       "9E1aOR9al1zqB7XyxM//hdPKVb70/WoJqrMabn+T0xjxCzj3LUZifvL2R8+d" +
       "l9dLDt7V2yWTW66C+OrPMki92Kmy9IUXX6qyS+cLX96swjFspxCyASjdCxcg" +
       "PCaQ+NBNJN39DuHeBsNxf7f1hRdfvHHaYznJ2bRyvGHqiy9/fH/7JgTSDyLw" +
       "mZsQ+HuPReDvP6bvv56L361Gr7+jn5sQd9n8vY8i7uf+oiHuKo/09rU7uE5Q" +
       "v0DvTlpv5r7wTZdM5ccq+AqX53kDEq6HG43x8PirtNyrwdnHlwOyA/f2C9nt" +
       "4O5mtx8m/oz+h9tuW4MJvPDIyOzl21dJx7cf/RLmDKeXnGM9GFg8SFbKXrAe" +
       "C+cLK4OHu17QNeLSecTf3ZzafS6+/fpTowdxdOveqEvQ3V5G/ffHoO1/nIs/" +
       "vPpg4z6VnFv5+zF35xOxd97B2p2Gc+97/yyo/t+PofpPzsUfV6P3XSRslNXN" +
       "Yr7Q1A4RzsMd5++g3vnI98hXX81an/uRt7z+q35E/q2rbwDufNn6NDd6vVvH" +
       "8f1f9tz3/nReOG5wIe7pq+98LiI5J10/dabt/H4rv+Lu/wGEIYyWET0AAA==");
}
