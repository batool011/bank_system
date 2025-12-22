package security;

public class ManagerAccess implements AccessStrategy {

    @Override
    public boolean canProcessTransaction() {
        return true;
    }

    @Override
    public boolean canViewReports() {
        return true;
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
