package security;

public interface AccessStrategy {
    boolean canProcessTransaction();
    boolean canViewReports();
    boolean canAddPalance();
    boolean canSubPalance();
    boolean changeState();
}
