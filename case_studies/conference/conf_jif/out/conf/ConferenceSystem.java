package conf;

import jif.util.HashMap;

/**
 * A system to handle the submission, approval and session allocation of papers
 to a conference
 */
public class ConferenceSystem {
    public Organiser organiser;
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
            this.allocations =
              new HashMap(
                jif.lang.LabelUtil.
                    singleton().
                    toLabel(
                      jif.lang.LabelUtil.
                          singleton().readerPolicy(
                                        this.jif$conf_ConferenceSystem_O,
                                        jif.lang.PrincipalUtil.topPrincipal()),
                      jif.lang.LabelUtil.singleton().topInteg()),
                jif.lang.LabelUtil.
                    singleton().
                    toLabel(
                      jif.lang.LabelUtil.
                          singleton().readerPolicy(
                                        this.jif$conf_ConferenceSystem_O,
                                        jif.lang.PrincipalUtil.topPrincipal()),
                      jif.lang.LabelUtil.singleton().topInteg())).
                jif$util$HashMap$();
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
            return this.declassifySessionNumber(paper);
        } else {
            return -1;
        }
    }
    
    private int declassifySessionNumber(final Paper paper) {
        jif.lang.JifObject sNoObj;
        try {
            sNoObj =
              this.allocations.
                get(
                  jif.lang.LabelUtil.
                      singleton().
                      toLabel(
                        jif.lang.LabelUtil.
                            singleton().readerPolicy(
                                          this.jif$conf_ConferenceSystem_O,
                                          jif.lang.PrincipalUtil.topPrincipal(
                                                                   )),
                        jif.lang.LabelUtil.singleton().topInteg()), paper);
        }
        catch (final NullPointerException e) { return -1; }
        jif.lang.JifObject sNoObjDeclass = sNoObj;
        jif.lang.JifInteger sNo;
        try {
            sNo =
              jif.lang.JifInteger.
                jif$cast$jif_lang_JifInteger(
                  jif.lang.LabelUtil.
                      singleton().
                      toLabel(
                        jif.lang.LabelUtil.
                            singleton().readerPolicy(
                                          this.jif$conf_ConferenceSystem_O,
                                          jif.lang.PrincipalUtil.topPrincipal(
                                                                   )),
                        jif.lang.LabelUtil.singleton().topInteg()),
                  sNoObjDeclass);
        }
        catch (final ClassCastException ex) { return -1; }
        int r;
        try { r = sNo.intValue(); }
        catch (final NullPointerException ex) { return -1; }
        int result = r;
        return result;
    }
    
    public void performAllocations() {
        try {
            for (int i = 0; i < this.numSubmissions; ++i) {
                this.allocations.
                  put(
                    this.submissions[i],
                    new jif.lang.JifInteger(
                      jif.lang.LabelUtil.
                          singleton().
                          toLabel(
                            jif.lang.LabelUtil.
                                singleton().
                                readerPolicy(
                                  this.jif$conf_ConferenceSystem_O,
                                  jif.lang.PrincipalUtil.topPrincipal()),
                            jif.lang.LabelUtil.singleton().topInteg())).
                        jif$lang$JifInteger$(i));
            }
        }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        catch (final NullPointerException ex) {  }
    }
    
    public void setAllocationsVisible() { this.allocationsVisible = true; }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1501367061343L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "f4ytKbqSrLvu8Y0l6/F7MIWasSidodCI");
    public static final String jlc$ClassType$jif$1 =
      ("wbd7rasiwOsqduqdYtheSRmPFX81wsXWffs2dNltdbUF3/3Ivn0r1Q+7r/g/" +
       "EG+TbvpOAAA=");
    
    public ConferenceSystem(final jif.lang.Principal jif$O) {
        super();
        this.jif$conf_ConferenceSystem_O = jif$O;
    }
    
    public void jif$invokeDefConstructor() { this.conf$ConferenceSystem$(); }
    
    private void jif$init() {  }
    
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
    public static final long jlc$SourceLastModified$jl = 1501367061343L;
    public static final String jlc$ClassType$jl =
      ("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" +
       "lcjJhSyocb5CjOUitHwORrvTkh0v+9pe");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "LZech3tp877nnAe+9bHJFctmcMi5XniNWGRWlVnH0rW3ciQxB3zcFIe94xSw" +
       "JYSlZewYBERWdQzl4w2A5eAJpBeAYtSpSBDEx85L/pVrBL7yEQSeH78KCldJ" +
       "Jd/3hKQg4qF8jnefF7skyN7MiX1FPIN85LJFez9J5QP3klQuv6evU8R/8Lr+" +
       "qw8kqTyQczk6J76999Wy+S9Jb5/9tk//mCX+7fHt6+ybZTl6fZmkHwnt2g4f" +
       "WOoqf9G7h8Yb7masD99Tn7yuvQczbe5z6QYFF8yevZ7iXtfGTQoenxz0N54w" +
       "9uPn4ofL0dvPjH3+JmOfv4/PDSruDB8+Gj3ztut69OVRMUx5+g+v6//16lTc" +
       "up+8+fHLqj/xBFL+7rn4bDl6ztVjK7QfSO57XD5NnXjW4wgDh28zIPkL1/WP" +
       "fnmEnaf8yHX9mT+eeH7mCWM/ey7+Xjl608kubxB0fBz254zJ49D+y9d1/uVh" +
       "f56SXdfBlyGWf/IEEn7+XPzDQSxnEuwL/lcpUud+6QYR95Js9aEdXNfrJxDx" +
       "mES085TVdU1+GUT80hOI+MK5+MVy9I5z5t/gCjyn+yNpuQjk/cP3baPRcx+5" +
       "rt/+5QnkPOVt1/Wb/3jq9C+fMPZr5+JXytFbUzs/P4Qg7ifmnUd+6tVU6ntH" +
       "o7f84+v6x788Cs5T/uZ1/cN/PAp+4wlj/+5c/Ho5elthl8QjidGPI+LyTOiD" +
       "Z1GPrn6Xuhz9xqPvN+688Kf8fONDH72TVcMJnFXDbfeFq3cRd86e6c75rPPi" +
       "OglsynYeeDXzwofufLJ0veLFx/vrFz700qc+lKavLpfL7+mb3DiPfjFNn8D3" +
       "//iEsd8+F79Zjt75akg/TiznE/iS1n9DLH//z55YrpL2H5SLV57lcOfjn9je" +
       "eRy7v+Fhdj/zOHb/7hPZ/aUnjP3Xc/E75eh1d3F5HHsvm7/3Efbe+oU/c+y9" +
       "yty9c638108CLny+m0idOC98/JIbfu79pB4Zn7pk2l617j2vufx5mSd++M41" +
       "uF7rN+GvEqGvgJNPMIMYPefOC8kd795md25ifxb1zb475p2P3XnhEcjkpTtX" +
       "ad53Hn3/sztnO9vZcGnSw4G1SvKC+eITQtoPX0gZ7Pl6QUcPC/sR6358Mv25" +
       "+JbrB1YPK9Lt+1CXeDm7QP3BE9TtEp79/hCCPCyScy/zoNLdfRn3zrvKdrfj" +
       "PPrePwGsb41eHetbF9j/XY7ed+GwXpSPZ/MFp3YITm4OnF9/vfORZ9hXj4XN" +
       "z//Ym1/3jh/b/ZurVxd3H/Q+zY1e51Rh+OB7pgfaT6e57XgX8p6+et10Ycmt" +
       "p4dg9Izbuf1MekXd/wfeAA4fCD4AAA==");
}
