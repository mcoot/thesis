package scheduler;

public class InvalidMeetingException extends Exception {
    
    public InvalidMeetingException scheduler$InvalidMeetingException$() {
        this.jif$init();
        {  }
        return this;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1501901059000L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "fwNcLYJYURIAAA==");
    
    public InvalidMeetingException() { super(); }
    
    public void jif$invokeDefConstructor() {
        this.scheduler$InvalidMeetingException$();
    }
    
    private void jif$init() {  }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1501901059000L;
    public static final String jlc$ClassType$jl =
      ("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");
}
