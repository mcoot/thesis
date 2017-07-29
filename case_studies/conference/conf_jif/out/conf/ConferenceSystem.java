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
            try {
                jif.lang.JifInteger sNo =
                  jif.lang.JifInteger.jif$cast$jif_lang_JifInteger(
                                        this.AL, this.allocations.get(paper));
                int toDowngrade = sNo.intValue();
                int result = toDowngrade;
                return result;
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
    public static final long jlc$SourceLastModified$jif = 1501310320568L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAL1cC3wVxbmfswkJITzCIyFACMcQkKAkCoJipIABBDxAJIAS" +
       "kbDZs0kW9pw92d0DCYhFfKByxSvgqxZ+0oIPLgV7q+LV+qi2gtVqoT7Q1sfV" +
       "q9eqtOqvVq2vO983s+89J8Hay++XmT2z830z833/+eb7ZmbZd5z0MHQyfKXS" +
       "Um12pmSjeq7SUi/qhhyv19TORbSoSfpi17PxW5em3hBIXiPpqRiLk4bYIsdI" +
       "gZg22zRdMTtNUhRbKa4Wa9KmotbEFMOsjZFCSUsapi4qSdNoJ5eRSIwUKbRE" +
       "TJqKaMrxWbqWMMlJsRRtqFXVzBq5w6xJibqYqMGu1NTXqaJhUE55WGox6ZnS" +
       "tdVKXNZNMiJGO85rq2KzrNbU83cx+FXboZOoxZ6Pjw0OObPR3XRKzfZblhf9" +
       "Zw7p10j6KckGUzQVqU5LmrQ/jaR3Qk40y7oxPR6X442kf1KW4w2yroiqspZW" +
       "1JKNZIChtCZFM63LxkLZ0NTVUHGAkU7RLkKbVmGM9GYiSUumplvDyWtRZDVu" +
       "/erRooqthklKHLGw4c2CciqLXlScst4iSrJFkrtKScZBFj4Ke4yV59MKlDQ/" +
       "IVN92U3lJkVaQAYwzalisrWmwdSVZCut2kNLmyDgoRmZ1oIiRGmV2Co3maTU" +
       "X6+evaK1ClAQQGKSYn815ES1NNSnJZd+js8/Z8u65OykgH2Oy5IK/e9Jicp9" +
       "RAvlFlmXk5LMCHuPjd0sljxyjUAIrVzsq8zqHLz042mnlj9+mNUZFlJnQfNK" +
       "WTKbpN3NfY+U1VVNzmEQ1AwFlO8ZOYK/nr+p7UjRiVVic4SX1dbLxxc+tXTD" +
       "XvkDgfSaQ/IkTU0nKI76S1oipaiyfp6clHWYInNIgZyM1+H7OSSfPseUpMxK" +
       "F7S0GLI5h+SqWJSn4W8qohbKAkSUT5+VZItmPadEsw2fO1KEkHz6R4bTv570" +
       "bz/PbzXJiplnL1tsyPosysVYNkOT0gmZTuBli5PKMrNNNhRjmSQacpNhpuMK" +
       "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" +
       "CrGdU0YZn+z/ttzF1h03RVbetiCW/+1F");
    public static final String jlc$ClassType$jif$1 = "2eMmdnXi/wC231r7IEsAAA==";
    
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
    public static final long jlc$SourceLastModified$jl = 1501310320568L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAM17adA021nQ3O8uSe4NSW4wIWTjI7nEe+nkdvdMz0x3rrGY" +
       "6Z5eptfpnu6ZbhJuep+e3vfpxihoQaKUKBA2Syi1sBSMwaKksFQ0P2QrKEop" +
       "S6AsFhUKNaaEH0hpKdgz7/vt7/1MfkA5VX3Oec/67Od53nrOZ74werosRrez" +
       "NOr8KK1errrMLV+WzKJ0HTwyy3I7dLxqfzcAfvp7v+EtP/bk6M3G6M1BolRm" +
       "Fdh4mlTuqTJGb4zd2HKLcuE4rmOMnk9c11HcIjCjoB8mpokxemsZ+IlZ1YVb" +
       "ym6ZRs154lvLOnOLy5l3OrnRG+00Kauitqu0KKvRW7ij2ZhgXQURyAVl9Qo3" +
       "esYL3Mgp89GfHz3BjZ72ItMfJr6du4MFeNkRJM/9w/RngwHMwjNt986Sp8Ig" +
       "carRVz284i7GL7DDhGHp62K3OqR3j3oqMYeO0VuvQIrMxAeVqggSf5j6dFoP" +
       "p1Sjd77mpsOk12emHZq++2o1esfD86SroWHWGy5kOS+pRm97eNplp1MxeudD" +
       "PLuPW18Q/sy3f2NCJ7cuMDuuHZ3hf3pY9N6HFsmu5xZuYrtXC9/4tdz3mG//" +
       "yU/dGo2GyW97aPLVnJ/4c7/3dR987+d+9mrOu26YI1pH165etX/IetO/eTf+" +
       "EvbkGYzXZ2kZnEXhAcwvXJWuR145ZYMsvv3ujufBl+8Mfk7+af2bfsT9/K3R" +
       "s8zoGTuN6niQquftNM6CyC0oN3ELs3IdZvQGN3Hwyzgzet3Q5oLEveoVPa90" +
       "K2b0VHTpeia9/D2QyBu2OJPoqaEdJF56p52Z1eHSPmWj0eh1wzd6z/C9fvg+" +
       "e11/XzX6+OrDH1VLtyCHXcqPEqldx25SlR9Vk+Cj1cEtg/Kjtlm6r5ZV7QTD" +
       "jEG+r6l+ab56DLyPloV9+eOj+N1BpSsrN355GM3+BM44nfH8svaJJwYWvPth" +
       "cxANukOnkeMWr9qfrper3/vsqz9/665CXFNokNXz7i8/vPvoiScuu/6ps9Jc" +
       "MXVgSTio+qDNb3xJ+dj6459635ODNGXtUwNBz1NfeFi271kEZmiZw96v2m/+" +
       "5H/+Hz/6PZ9I70l5NXrhEeV7dOVZed73MIZFarvOYJzubf+1t80ff/UnP/HC" +
       "rbMkvGHArDIHqRkU/L0Pn/GAEr1yxyCdqXKLGz3npUVsRuehO1bk2epQpO29" +
       "ngvpn7u03/RHw++J4fvD83eWt3PHuR6sDn4t67fvCns1SsT/+K3f+eE/buH4" +
       "MIx9cIJ9CJlkV2Jy5uZDFLwY248o2Q/8yi/+l8mtM+Z37PKb7zPgilu9cp8t" +
       "OG/2xovWP39POLaF6w7zfu37pO/67i988usvkjHMeP9NB75wLs90MQd6pMW3" +
       "/Gz+q7/x6z/0b2/dk6Zq9ExWW1FgXyB/97DRB+4dNZiJaDBVAyTlC2oSp07g" +
       "BaYVuWfJ/N9v/hr4x//bt7/lSryioeeKWcXog//vDe71f+Vy9E0//w1/8N7L" +
       "Nk/Y52vqHjnuTbuyfV9+b+dFUZjdGY7TN//Se77/Z8wfGKzoYLnKoHcvxuiJ" +
       "a2U5A/XWQTgGLr18vpAGUQ4SO8jM6ILwBy8T/vSlBM5ydFk2uoxB5+Jdp8vY" +
       "2y79z5WPXhHk+a69pxYG+Jm/+U78z37+gs89tTjv8c7To6ZDM+/T2PGPxL9/" +
       "633P/NSt0euM0Vsu17yZVJoZ1WeGG8NFXeLXndzoyx4Yf/DSvbphXrmr9u9+" +
       "WCXvO/Zhhbxnsob2efa5/br7dXAgxPNnIgFXjVvT6/pd59G3ZOfy+dMTo0tj" +
       "dlnyVZfyfefia674cm5+4ErkqtEb0sI3k2DQ0DvsetPFUop3uq+U6lyOHwTh" +
       "Q8P35cPRznVN3wDCR74YEG4tuLtn3xUVzrTc6Kaz33jn7LcNZ37XdV3ccDbx" +
       "GmdXo9dlRdAMNup0d9OL4D13vVl+XR/v23TgsRlFqX3xGEstKINBk26QyEHC" +
       "48F8NNdOi/upT/+VP3r52z996z7P7v2POFf3r7ny7i6kefZCn9Nwylc/7pTL" +
       "CvJ3fvQT/+zvf+KTV57PWx/0U1ZJHf/Df/d/fuHl7/vNn7vhanydlaaRayav" +
       "Se2vGb6vGAjyT6/rv30DteUrap8L6lGynlf9rev6+x8g65sG2JTaioOyPFP2" +
       "spS9RvxcCdXoycFHfk3YoOF7x7Dr56/rn7kBNuOxsJ1X/fR1/S8fgO258j7A" +
       "HvVqL2bwis+/+5nf+Pwvfdl7Pnu5kJ+yhgvtorkPhwOPevsPOPEXrr/hQfze" +
       "fw3Zr9+E3x21efaispKZXWsx8JARHp8L8w453JsV49ZFKavBIgXJtYUelPOZ" +
       "yE38K09zdy4+frp7wq2rZXeAuLogLsqLR2ninu+aO2NX/lWQvnw38hoGT4/A" +
       "Woy+6iEa8xfy3DPTP8x/5ueoD9jfeWv05F0L+0io9OCiVx60q88W7hDpJdsH" +
       "rOtXXhHoguC5+OrHXE3VY8aaczH4YU/bZwrcwf4t9yhzdTucXlOcXxy+d41G" +
       "T/LXNXyDOPePFefzKui6fulBcb7Pgt0DbTC4FyNBm+WBN7P7ILvSwicGg/n0" +
       "5OXpy5cr+Ztvlp0nr2XnmfISfJ//OtyRoK84RvYLd/xDbZDQ4fwXhmNvoM5V" +
       "wHoDCINkvOneNC4dotpv+62//gt/7f2/Mdiz9ejp5nwPD4bvvr2E+hz2f+tn" +
       "vvs9z336N7/t4nUNIvaxv/r8X/gn513/8rn4S0NIfIZOSevCdjmzrPiLm+Q6" +
       "dwF8yBY9NfD1JgCr2yMaKZnFnR8H2/ik1U5W7JVtuGa2Pc505ALn7U3ILkI8" +
       "XQcZs1guidNizSyU0CKMEgp3WNZiYwcicP1AeuyyOymNn58MAEoZifO1eQ5w" +
       "GpAHY7/S8nQ738Clp+WYm1di3mj5uBExdFICKLZGabMDgH28HffoBBq+CQi4" +
       "1tyILcOZ9hBPbzqP3StqDI+zWDm6+VxRAzA/HLoGxraibCmp4mUBPJdOu6kb" +
       "Tw5LZh9IWS4HXIhYOlM6jG/443EvO/y2EtSDbLEmsjMxNk4ra0XyYnk0SFxR" +
       "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" +
       "qH7Q9TUCL2XDHNyUME+jqTnT4iGyZw4k");
    public static final String jlc$ClassType$jl$1 =
      ("vig6PR2iPX0vrecCQxvr3WF+SMuZxJadnySUEEfbutvNdxseKlWnxIVtFEPK" +
       "hts1qiWXaQDSQkjMQllXNq5A7GlK5kDdak/9MaFDVMLG2JKmt+WWLOaLwd8H" +
       "KbQLNUGDi32SEZKPApPoiOmgZ28G58LYbbVqF7L1TkloEzNSIE9Nns5OYum1" +
       "g49knuBVg2egjLsrcTnxlOYoVguEY8hNu4rnJbGIUgMKxiI7gUmIqwGmDgay" +
       "rKuJ4nLwatkRBueYRczJu6U2oZA9fGw5qIvRsk/SPUsZWB/tKZ4VkWQ9BBUH" +
       "ms7IQt0Q+509145+L0b7MdgR8zG6nkSJezhUahgoQCsc+UNdLZtJ20klC2mt" +
       "2u+DZLXTdsVqk1JI3s9cpPQqqYawiT4Ven7M+H6ZowfsUHBOFM3BNYFmwhgj" +
       "1NJEFakCsHzaIQlrs1PXWdQnNpfx6SJrGjcjKEnn81megDTaH3AN3Ha9dOqW" +
       "kqUzGN53KrLdWkExRgH6UKRdcKon0iqYB7tsKoHRlARVfCLTk3bfkTm32DYE" +
       "jZR+LY8jNLEnIjmQp1sjHIoWKWm59OyodGu9xJTp+X8IEKDFEl5YzZ6e902A" +
       "S6ZjNWUsrP2xWgkbJNoXUp5WGgGcjjkGCQ230bM9lkDOHPUBr6mX+2PL+5NF" +
       "U+bMgDKBYh6GgIvdPnGsXDueJLI1luyxD8DAtbfOQpF403Gs2qkQZwp6Ei2i" +
       "jmAcJqtWWS+0+rTY12FpRdv1lBJDdS9bHs3MTjsETw74XBNxoIq5DljEM9o5" +
       "sGYyjtuNig1eqSIKQZIWp6ZUq7lMuvxqXM7WlX5k665Exs5E5vmJQg/aUsKR" +
       "xfk0PE/NabBMUrKD04Not+qSwSTjxCMaHYiMJ08VCV8wEkPLos+tUb1xJSy0" +
       "92tNjert4NLChL6fQ5GN8vVMX6oaUDN9BSoxJ4B6vGa8NK2VfUBN5L3WKLVZ" +
       "wmt5HgfpfqXNTxOawAnzOLdLl+grYAbXiR1Tkz073AgTT9egvcpiot6gqmUx" +
       "Cbo8tG60EdckkZ1ACZ/AW85b7wsaMKJxihYYND8u8uJQg+NEpneGgC5Kpz7p" +
       "3BHpB0nxfYcuAg5MzFB3HE1dn2QdowB6n02h8aSy+E0veD7NyrOk1nyQBCtr" +
       "mrBqNJ0xJJWeeoA8sK3fUtjAxEE6h8s5dbJ5oXa5zZjF3hlH2367NE2cCxFd" +
       "5WBih7kHIsd7l7cMRm72JcJ7yspLN+Dag6SO9OPpVu+ZcqYu1odSqnkw8I6E" +
       "Obj0KrPk2drHJInk9dM2wjqQH6K+hQo0R980sNVGHA93aNC1HN8VfNSUJblt" +
       "ycOG5cyTsmhQlFZYhoT4bWClgLhps21nyUoU7ZWSlPWuOuDjwqYycKFBgYdu" +
       "+xYnT1isagqRTa3iwJQTeWqsjQm/2K3sIW6yjL3QM24+llbdpC7ikpnPfdJX" +
       "5GSpLZiDNtnYQZLoEjLtagRMNC/ARbSlZSkQ6XHW4DnHLOzdQQ8xJ166a33O" +
       "a6vlZDA9EAGRK41tVKYud4qm2gc/ZGRTGy+m/jY1MseK3OVKhNl1u6LWXn/Y" +
       "xQ4eRSffyoeovAR0xQ8MdLNfhvrY7OvQ2vegzCFQEBPcRqhdzlghxExZiZU4" +
       "OcXLlthM/NPeL8eNdCJtqO9Ia8r6sctYEUntbIheChYeYVESAZM0EkwcN06e" +
       "kMWKA9VrgCfqg7otxuJ0lnr8lE4snVvrGzkTUHKCacelzx9SaQjEELPZrUBB" +
       "PwyC2542dX80oJwjcFQLSKNSDgdRD72QQ1OxKBQWjnkDb6EOLTNvlniT02Fd" +
       "sGdrJlPLLe4URWKmReR7VgPYpnUCd6zimHsJidUo207J+sTssvUKUKoC0O1J" +
       "EwahBR97G5sIKaLwiGR3zsGzYywDJYnrki0wLQo86mDRUjUYjATVj081ZfVw" +
       "1wKQRQ7itPXhwwGsmKKElpP1Ru9XntJKPNesjti01+kDvdeNpWstUDaa0z3d" +
       "HBijtgnrNGYLqyMxh9VB6mhuTZdm5wE2d4kqY0QX9UUvAbqOL/khQMFJbWWi" +
       "Dn6+lOtWwKmq81JiMDCdMWZKi2arbOmPs70uw6iXFATXxBR1lCm545tqUB83" +
       "4MY+o84RYMZhsz71FrTHnIohJjY5DHGkZhVoyrhpFJNn0wrJkA08lkPfSev9" +
       "2PKxY9BZPsDB5GoHoDmy4SdhHyFutcLbdlX50WAquSPrR3JKTdyWOXadQdgB" +
       "GqLaUmuXjW7L9HjXd6vGHe+IbgYZBb1ukGXIKooJTbWxMEPsOcoZSbKsSHQ1" +
       "9QwY64aL9bSdYuVuC1MilGHpzvFkyIk9H5wx+yOxXAR4w8SJ72JtQ0QdSm+G" +
       "ODdmwhmQuJ7lH47smsg73PbmoQD2yxhdxa0G5BO/rsE4qA5gAR76ZY1aWiII" +
       "bFJ4yBQNtk1DG8JUOThxqWuGPuWDWakog+mkQ9sFKZ7vVi6BzuRTPwYSolwR" +
       "/LJxZQuhPUhEGXFPQESnLwyk5ephhcfF4to5wUtwBazzWZHAQxDVH+HeVDQP" +
       "WGc4hFq9IRtZ1LJY5Ho2teYdnk+X7CrqVzN7vtzTzUQIYF9aHqENgo53Kc8x" +
       "kllxhxVXOXNqW0yKmdRXzKJ3iZylw/1kI1ksH6ekEIxLZqaBDJqz0hZq+43E" +
       "yD0GNkmsA73H1TzkA3wYnxij2S5gL61noU0t13VRUggQHY94N7hwGKz0macP" +
       "3oQd7hEjktj9xlX9nToVMfSwET18WksYCCPLqnO4hYcdCTDjDdMDRW8Ik+dw" +
       "j/JFhZoNTPOLPZqmyTyH9nv7NIeFqFQ1ql3uuu2mQpPMMNZ2Ta/oHtmP1z1G" +
       "zvCEWE+32nwpsURtoRGj18R8gQWdzdmLJRSIjlS7e3fqsRtKTqf+vPMElHPC" +
       "7XZOTykzY0Aq6efHIUAYgKKk/Ci40wmfEnVnixPQOU0lfTldYWtSs4N5uZN2" +
       "fJi0O8FbwrAHefF0bJ26rHKw3d5z24pyt3OQBnBTYrU6WeszrsxjiKjCpAG6" +
       "XI1M2TEasNnFC8M70q6Kn7QgzLoQQpqFkNJavSy6Wi9JDS8oR4V0IwF6sKp6" +
       "Ej5AE1mz3CrAdyAAk+dUgO+4zip4/pLzcDdj/xh454FP3phc8Y6xy8dOsg/A" +
       "Fh9P4GLOrMrFYvGRj5ynfPp6wy9/ZMMX4NfY8ipJ5Hsfk+RDP5Cf8a7zZpdc" +
       "24fTa18Vz1M+dDnidC/p5P13k04uv2eus82/97r+jvuSTu7L3xydE9ne81oP" +
       "Ay5JbD/0Fz/9g474d+Fb19k0YjV6Q5VmH4rcxo3u2+rZSzu7C8Zzd5Lfh+/J" +
       "6Lo27s+cuUelhzC4QPbs9RL9ulYexuDmZJ+/95ixHz4Xf6cavf1M2BceJuwL" +
       "9+B5CIvbw4cONP1f1/Vvf2lYnJf81nX966+NxRP3sjCty67/6DGo/Ni5+AfV" +
       "6C0HM3Ei975kvZvyY5o0cG5C7LzrZgDyb1zX/ZeG2HlJd12XXxx7/vljxv7F" +
       "ufiJavQm360eQujjN0H/0vAN0vGce11TXxr05yXkdf11XwJbfuoxKFwSAT83" +
       "sOWMgnuB/yrl6dy/uwmJ9w3fN45Gb/6m6zr40pA4Lzlc19YXx4JffMzYvz4X" +
       "P1eN3pq5xfkdwuJectp55B/fhME5EfVTo9Hzz13Vb/m9Lw2D85Lfva7/6xeH" +
       "wS8/ZuxXz8UvVaO3lW61eCQ5+CYkLq90PnDm8bXtvNTV6FcefT5x+8U/2dcT" +
       "L334dj5Er0Fep5X74tWzhNtnZb59vh6CpElDl3C9+96svPjS7W+sDkH58s0m" +
       "7sWXXvnES1n22my5/J55mBjn0V/LsseQ/T88Zuw/nYt/P9yprwX0TVw5X1qX" +
       "lPYHufLEv/r/jitXaev3syWozmy4/fVuY0YvLrhvNGPrE7c/ch68NC+pkFet" +
       "S0K9WgXR1Z9lkPiRW6XJiy+9XKWXwRe/tFWFazpuIaWDoHQvXgThMY7EB28C" +
       "6e5zkHsHDNf93d4XX3rpxmWPxSRjksr1h6UvvfIx5fZNEkg9KIGvu0kCf+ex" +
       "Evj5x4x94Vz8djV6/R3+3CRxl8Pf86jEfe7/N4m7Sue9fW0Ort8JXETvTnZ1" +
       "6r349ZeE8ccy+Eouz+sGSbiebjbmw/OvsqOvJqcfIwfJDrzbL6a3g7uH3X4Y" +
       "+LP0P9x32x5U4MVHZqav3L7K/b796IOkszi97Ob1oGDRQNlt+qL9WHG+oDJY" +
       "uOsNPTMq3Ufs3c0Z9ufiW65ffD0oR7fuzbo43afLrN9/jLT9wbn471fvZu5j" +
       "ybmXv1/m7rzUe8cdWbvTcR59zx8H1H/42lA/cTn1f1aj914obJbVzWS+wHQa" +
       "PJyHB87P0d7xyLPwq8fL9md/8M2v/4ofVH/56inGnQfGz3Cj13t1FN3/wOq+" +
       "9jNZ4XrBBfBnrp5bXUjyxFODR3uG7dx+OrvC7v8CG7myEJg+AAA=");
}
