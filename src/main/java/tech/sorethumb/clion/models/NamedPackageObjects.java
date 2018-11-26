package tech.sorethumb.clion.models;

/**
 * Creating this so the other classes have something in common to inherit from.  I'll use this in other locations where
 * I'm filtering similar, nested objects with a display name I'd like to use.
 */
public interface NamedPackageObjects {
    String getDisplayName();
}
