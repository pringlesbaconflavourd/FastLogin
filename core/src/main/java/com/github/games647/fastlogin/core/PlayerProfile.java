package com.github.games647.fastlogin.core;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public class PlayerProfile {

    private String playerName;

    private long rowId;

    private UUID uuid;
    private boolean premium;
    private String lastIp;
    private Instant lastLogin;

    public PlayerProfile(long rowId, UUID uuid, String playerName, boolean premium, String lastIp, Instant lastLogin) {
        this.rowId = rowId;
        this.uuid = uuid;
        this.playerName = playerName;
        this.premium = premium;
        this.lastIp = lastIp;
        this.lastLogin = lastLogin;
    }

    public PlayerProfile(UUID uuid, String playerName, boolean premium, String lastIp) {
        this(-1, uuid, playerName, premium, lastIp, Instant.now());
    }

    public synchronized boolean isSaved() {
        return rowId >= 0;
    }

    public synchronized String getPlayerName() {
        return playerName;
    }

    public synchronized void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public synchronized long getRowId() {
        return rowId;
    }

    public synchronized void setRowId(long generatedId) {
        this.rowId = generatedId;
    }

    //todo: this should be optional
    public synchronized Optional<UUID> getId() {
        return Optional.ofNullable(uuid);
    }

    public synchronized void setId(UUID uuid) {
        this.uuid = uuid;
    }

    public synchronized boolean isPremium() {
        return premium;
    }

    public synchronized void setPremium(boolean premium) {
        this.premium = premium;
    }

    public synchronized String getLastIp() {
        return lastIp;
    }

    public synchronized void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public synchronized Instant getLastLogin() {
        return lastLogin;
    }

    public synchronized void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public synchronized String toString() {
        return this.getClass().getSimpleName() + '{' +
                "playerName='" + playerName + '\'' +
                ", rowId=" + rowId +
                ", uuid=" + uuid +
                ", premium=" + premium +
                ", lastIp='" + lastIp + '\'' +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
