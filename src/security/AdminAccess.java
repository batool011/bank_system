package security;

public class AdminAccess implements AccessStrategy {

    @Override
    public boolean canProcessTransaction() {
        return true;
    }

    @Override
    public boolean canViewReports() {
        return false;
    }

    @Override
    public boolean canAddPalance() {
        return true;
    }

    @Override
    public boolean canSubPalance() {
        return true;
    }

    @Override
    public boolean changeState() {
        return true;
    }
}
