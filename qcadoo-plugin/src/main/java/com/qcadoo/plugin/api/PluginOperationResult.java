/**
 * ***************************************************************************
 * Copyright (c) 2010 Qcadoo Limited
 * Project: Qcadoo Framework
 * Version: 0.4.0
 *
 * This file is part of Qcadoo.
 *
 * Qcadoo is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * ***************************************************************************
 */

package com.qcadoo.plugin.api;

/**
 * Holder for the status and dependencies information returned by {@link PluginManager} methods.
 * 
 * @since 0.4.0
 */
public final class PluginOperationResult {

    private final PluginOperationStatus status;

    private final PluginDependencyResult pluginDependencyResult;

    private PluginOperationResult(final PluginOperationStatus status) {
        this.status = status;
        this.pluginDependencyResult = PluginDependencyResult.satisfiedDependencies();
    }

    private PluginOperationResult(final PluginOperationStatus status, final PluginDependencyResult pluginDependencyResult) {
        this.status = status;
        this.pluginDependencyResult = pluginDependencyResult;
    }

    /**
     * Returns true if operation was successful: {@link PluginOperationStatus#SUCCESS},
     * {@link PluginOperationStatus#SUCCESS_WITH_MISSING_DEPENDENCIES} and {@link PluginOperationStatus#SUCCESS_WITH_RESTART}.
     * 
     * @return true if success
     */
    public boolean isSuccess() {
        switch (status) {
            case SUCCESS:
            case SUCCESS_WITH_RESTART:
            case SUCCESS_WITH_MISSING_DEPENDENCIES:
                return true;
            default:
                return false;
        }
    }

    /**
     * Returns true if operation requires restart: {@link PluginOperationStatus#SUCCESS_WITH_RESTART}.
     * 
     * @return true if success
     */
    public boolean isRestartNeccessary() {
        return PluginOperationStatus.SUCCESS_WITH_RESTART.equals(status);
    }

    /**
     * Returns status.
     * 
     * @return status
     */
    public PluginOperationStatus getStatus() {
        return status;
    }

    /**
     * Returns dependencies information.
     * 
     * @return dependencies information
     */
    public PluginDependencyResult getPluginDependencyResult() {
        return pluginDependencyResult;
    }

    /**
     * Creates holder with {@link PluginOperationStatus#SUCCESS_WITH_RESTART}
     * 
     * @return holder
     */
    public static PluginOperationResult successWithRestart() {
        return new PluginOperationResult(PluginOperationStatus.SUCCESS_WITH_RESTART);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#SUCCESS}
     * 
     * @return holder
     */
    public static PluginOperationResult success() {
        return new PluginOperationResult(PluginOperationStatus.SUCCESS);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#SYSTEM_PLUGIN_DISABLING}
     * 
     * @return holder
     */
    public static PluginOperationResult systemPluginDisabling() {
        return new PluginOperationResult(PluginOperationStatus.SYSTEM_PLUGIN_DISABLING);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#SYSTEM_PLUGIN_UNINSTALLING}
     * 
     * @return holder
     */
    public static PluginOperationResult systemPluginUninstalling() {
        return new PluginOperationResult(PluginOperationStatus.SYSTEM_PLUGIN_UNINSTALLING);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#SYSTEM_PLUGIN_UPDATING}
     * 
     * @return holder
     */
    public static PluginOperationResult systemPluginUpdating() {
        return new PluginOperationResult(PluginOperationStatus.SYSTEM_PLUGIN_UPDATING);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#CORRUPTED_PLUGIN}
     * 
     * @return holder
     */
    public static PluginOperationResult corruptedPlugin() {
        return new PluginOperationResult(PluginOperationStatus.CORRUPTED_PLUGIN);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#CANNOT_UPLOAD_PLUGIN}
     * 
     * @return holder
     */
    public static PluginOperationResult cannotUploadPlugin() {
        return new PluginOperationResult(PluginOperationStatus.CANNOT_UPLOAD_PLUGIN);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#CANNOT_DOWNGRADE_PLUGIN}
     * 
     * @return holder
     */
    public static PluginOperationResult cannotDowngradePlugin() {
        return new PluginOperationResult(PluginOperationStatus.CANNOT_DOWNGRADE_PLUGIN);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#DEPENDENCIES_CYCLES_EXISTS}
     * 
     * @return holder
     */
    public static PluginOperationResult dependenciesCyclesExists() {
        return new PluginOperationResult(PluginOperationStatus.DEPENDENCIES_CYCLES_EXISTS);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#PLUGIN_ENABLING_IS_NOT_ALLOWED}
     * 
     * @return holder
     */
    public static PluginOperationResult pluginEnablingIsNotAllowed() {
        return new PluginOperationResult(PluginOperationStatus.PLUGIN_ENABLING_IS_NOT_ALLOWED);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#DEPENDENCIES_TO_ENABLE}
     * 
     * @param pluginDependencyResult
     *            dependencies information
     * @return holder
     */
    public static PluginOperationResult dependenciesToEnable(final PluginDependencyResult pluginDependencyResult) {
        return new PluginOperationResult(PluginOperationStatus.DEPENDENCIES_TO_ENABLE, pluginDependencyResult);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#UNSATISFIED_DEPENDENCIES}
     * 
     * @param pluginDependencyResult
     *            dependencies information
     * @return holder
     */
    public static PluginOperationResult unsatisfiedDependencies(final PluginDependencyResult pluginDependencyResult) {
        return new PluginOperationResult(PluginOperationStatus.UNSATISFIED_DEPENDENCIES, pluginDependencyResult);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#SUCCESS_WITH_MISSING_DEPENDENCIES}
     * 
     * @param pluginDependencyResult
     *            dependencies information
     * @return holder
     */
    public static PluginOperationResult successWithMissingDependencies(final PluginDependencyResult pluginDependencyResult) {
        return new PluginOperationResult(PluginOperationStatus.SUCCESS_WITH_MISSING_DEPENDENCIES, pluginDependencyResult);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#DEPENDENCIES_TO_DISABLE}
     * 
     * @param pluginDependencyResult
     *            dependencies information
     * @return holder
     */
    public static PluginOperationResult dependenciesToDisable(final PluginDependencyResult pluginDependencyResult) {
        return new PluginOperationResult(PluginOperationStatus.DEPENDENCIES_TO_DISABLE, pluginDependencyResult);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#DEPENDENCIES_TO_UNINSTALL}
     * 
     * @param pluginDependencyResult
     *            dependencies information
     * @return holder
     */
    public static PluginOperationResult dependenciesToUninstall(final PluginDependencyResult pluginDependencyResult) {
        return new PluginOperationResult(PluginOperationStatus.DEPENDENCIES_TO_UNINSTALL, pluginDependencyResult);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#UNSATISFIED_DEPENDENCIES_AFTER_UPDATE}
     * 
     * @param pluginDependencyResult
     *            dependencies information
     * @return holder
     */
    public static PluginOperationResult unsatisfiedDependenciesAfterUpdate(final PluginDependencyResult pluginDependencyResult) {
        return new PluginOperationResult(PluginOperationStatus.UNSATISFIED_DEPENDENCIES_AFTER_UPDATE, pluginDependencyResult);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#CANNOT_INSTALL_PLUGIN_FILE}
     * 
     * @return holder
     */
    public static PluginOperationResult cannotInstallPlugin() {
        return new PluginOperationResult(PluginOperationStatus.CANNOT_INSTALL_PLUGIN_FILE);
    }

    /**
     * Creates holder with {@link PluginOperationStatus#PLUGIN_NOT_EXIST}
     * 
     * @return holder
     */
    public static PluginOperationResult pluginNotExist() {
        return new PluginOperationResult(PluginOperationStatus.PLUGIN_NOT_EXIST);
    }
}
