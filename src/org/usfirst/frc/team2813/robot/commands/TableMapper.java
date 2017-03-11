package org.usfirst.frc.team2813.robot.commands;

import java.nio.ByteBuffer;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;

import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

public class TableMapper implements ITable {

	public TableMapper(ITable table, Dictionary<String, String> mapping) {
		this.mapping = mapping;
		this.table = table;
	}

	public Dictionary<String, String> mapping;
	public ITable table;

	public boolean containsKey(String key) {
		return mapping.get(key) != null && table.containsKey(mapping.get(key));
	}

	public boolean containsSubTable(String key) {
		return mapping.get(key) != null && table.containsSubTable(key);
	}
	
	public ITable getSubTable(String key) {
		return table.getSubTable(mapping.get(key));
	}

	public Set<String> getKeys(int types) {
		// filter the keys by what's in the dictionary and then convert to a set
		return table.getKeys(types).stream().filter((key) -> mapping.get(key) != null).collect(HashSet<String>::new,
				HashSet<String>::add, HashSet<String>::addAll);
	}

	public Set<String> getKeys() {
		return table.getKeys().stream().filter((key) -> mapping.get(key) != null).collect(HashSet<String>::new,
				HashSet<String>::add, HashSet<String>::addAll);
	}

	public Set<String> getSubTables() {
		return table.getSubTables().stream().filter((key) -> mapping.get(key) != null).collect(HashSet<String>::new,
				HashSet<String>::add, HashSet<String>::addAll);
	}

	public void setPersistent(String key) {
		table.setPersistent(mapping.get(key));

	}

	@Override
	public void clearPersistent(String key) {
		table.clearPersistent(mapping.get(key));
	}

	@Override
	public boolean isPersistent(String key) {
		return table.isPersistent(mapping.get(key));
	}

	@Override
	public void setFlags(String key, int flags) {
		table.setFlags(mapping.get(key), flags);
	}

	@Override
	public void clearFlags(String key, int flags) {
		table.clearFlags(mapping.get(key), flags);
	}

	@Override
	public int getFlags(String key) {
		return table.getFlags(mapping.get(key));
	}

	@Override
	public void delete(String key) {
		table.delete(mapping.get(key));
	}

	@Deprecated
	@Override
	public Object getValue(String key) throws TableKeyNotDefinedException {
		return table.getValue(mapping.get(key));
	}

	@Override
	public Object getValue(String key, Object defaultValue) {
		if (mapping.get(key) == null)
			return defaultValue;
		return table.getValue(mapping.get(key), defaultValue);
	}

	@Override
	public boolean putValue(String key, Object value) throws IllegalArgumentException {
		return table.putValue(mapping.get(key), value);
	}

	@Deprecated
	@Override
	public void retrieveValue(String key, Object externalValue) throws TableKeyNotDefinedException {
		table.retrieveValue(mapping.get(key), externalValue);
	}

	@Override
	public boolean putNumber(String key, double value) {
		if (mapping.get(key) == null)
			return false;
		return table.putNumber(mapping.get(key), value);
	}

	@Override
	public boolean setDefaultNumber(String key, double defaultValue) {
		return table.setDefaultNumber(mapping.get(key), defaultValue);
	}

	@Deprecated
	@Override
	public double getNumber(String key) throws TableKeyNotDefinedException {
		return table.getNumber(mapping.get(key));
	}

	@Override
	public double getNumber(String key, double defaultValue) {
		if (mapping.get(key) == null)
			return defaultValue;
		return table.getNumber(mapping.get(key), defaultValue);
	}

	@Override
	public boolean putString(String key, String value) {
		if (mapping.get(key) == null)
			return false;
		return table.putString(mapping.get(key), value);
	}

	@Override
	public boolean setDefaultString(String key, String defaultValue) {
		return table.setDefaultString(mapping.get(key), defaultValue);
	}

	@Deprecated
	@Override
	public String getString(String key) throws TableKeyNotDefinedException {
		return table.getString(mapping.get(key));
	}

	@Override
	public String getString(String key, String defaultValue) {
		if (mapping.get(key) == null)
			return defaultValue;
		return table.getString(mapping.get(key), defaultValue);
	}

	@Override
	public boolean putBoolean(String key, boolean value) {
		if (mapping.get(key) == null)
			return false;
		return table.putBoolean(mapping.get(key), value);
	}

	@Override
	public boolean setDefaultBoolean(String key, boolean defaultValue) {
		return table.setDefaultBoolean(mapping.get(key), defaultValue);
	}

	@Deprecated
	@Override
	public boolean getBoolean(String key) throws TableKeyNotDefinedException {
		return table.getBoolean(mapping.get(key));
	}

	@Override
	public boolean getBoolean(String key, boolean defaultValue) {
		if (mapping.get(key) == null)
			return defaultValue;
		return table.getBoolean(mapping.get(key), defaultValue);
	}

	@Override
	public boolean putBooleanArray(String key, boolean[] value) {
		return false;
	}

	@Override
	public boolean setDefaultBooleanArray(String key, boolean[] defaultValue) {
		return table.setDefaultBooleanArray(mapping.get(key), defaultValue);
	}

	@Override
	public boolean putBooleanArray(String key, Boolean[] value) {
		if (mapping.get(key) == null)
			return false;
		return table.putBooleanArray(mapping.get(key), value);
	}

	@Override
	public boolean setDefaultBooleanArray(String key, Boolean[] defaultValue) {
		return table.setDefaultBooleanArray(mapping.get(key), defaultValue);
	}

	@Deprecated
	@Override
	public boolean[] getBooleanArray(String key) throws TableKeyNotDefinedException {
		return table.getBooleanArray(mapping.get(key));
	}

	@Override
	public boolean[] getBooleanArray(String key, boolean[] defaultValue) {
		if (mapping.get(key) == null)
			return defaultValue;
		return table.getBooleanArray(mapping.get(key), defaultValue);
	}

	@Override
	public Boolean[] getBooleanArray(String key, Boolean[] defaultValue) {
		if (mapping.get(key) == null)
			return defaultValue;
		return table.getBooleanArray(mapping.get(key), defaultValue);
	}

	@Override
	public boolean putNumberArray(String key, double[] value) {
		if (mapping.get(key) == null)
			return false;
		return table.putNumberArray(mapping.get(key), value);
	}

	@Override
	public boolean setDefaultNumberArray(String key, double[] defaultValue) {
		return table.setDefaultNumberArray(mapping.get(key), defaultValue);
	}

	@Override
	public boolean putNumberArray(String key, Double[] value) {
		if (mapping.get(key) == null)
			return false;
		return table.putNumberArray(mapping.get(key), value);
	}

	@Override
	public boolean setDefaultNumberArray(String key, Double[] defaultValue) {
		return table.setDefaultNumberArray(mapping.get(key), defaultValue);
	}

	@Deprecated
	@Override
	public double[] getNumberArray(String key) throws TableKeyNotDefinedException {
		return table.getNumberArray(mapping.get(key));
	}

	@Override
	public double[] getNumberArray(String key, double[] defaultValue) {
		if (mapping.get(key) == null)
			return defaultValue;
		return table.getNumberArray(mapping.get(key), defaultValue);
	}

	@Override
	public Double[] getNumberArray(String key, Double[] defaultValue) {
		if (mapping.get(key) == null)
			return defaultValue;
		return table.getNumberArray(mapping.get(key), defaultValue);
	}

	@Override
	public boolean putStringArray(String key, String[] value) {
		if (mapping.get(key) == null)
			return false;
		return table.putStringArray(mapping.get(key), value);
	}

	@Override
	public boolean setDefaultStringArray(String key, String[] defaultValue) {
		return table.setDefaultStringArray(mapping.get(key), defaultValue);
	}

	@Deprecated
	@Override
	public String[] getStringArray(String key) throws TableKeyNotDefinedException {
		return table.getStringArray(mapping.get(key));
	}

	@Override
	public String[] getStringArray(String key, String[] defaultValue) {
		if (mapping.get(key) == null)
			return defaultValue;
		return table.getStringArray(mapping.get(key), defaultValue);
	}

	@Override
	public boolean putRaw(String key, byte[] value) {
		if (mapping.get(key) == null)
			return false;
		return table.putRaw(mapping.get(key), value);
	}

	@Override
	public boolean setDefaultRaw(String key, byte[] defaultValue) {
		return table.setDefaultRaw(mapping.get(key), defaultValue);
	}

	@Override
	public boolean putRaw(String key, ByteBuffer value, int len) {
		if (mapping.get(key) == null)
			return false;
		return table.putRaw(mapping.get(key), value, len);
	}

	@Deprecated
	@Override
	public byte[] getRaw(String key) throws TableKeyNotDefinedException {
		return table.getRaw(mapping.get(key));
	}

	@Override
	public byte[] getRaw(String key, byte[] defaultValue) {
		// TODO Auto-generated method stub
		return table.getRaw(mapping.get(key), defaultValue);
	}

	@Override
	public void addTableListener(ITableListener listener) {
		table.addTableListener(listener);

	}

	@Override
	public void addTableListener(ITableListener listener, boolean immediateNotify) {
		table.addTableListener(listener, immediateNotify);
	}

	@Override
	public void addTableListenerEx(ITableListener listener, int flags) {
		table.addTableListenerEx(listener, flags);

	}

	@Override
	public void addTableListener(String key, ITableListener listener, boolean immediateNotify) {
		table.addTableListener(mapping.get(key), listener, immediateNotify);
	}

	@Override
	public void addTableListenerEx(String key, ITableListener listener, int flags) {
		table.addTableListenerEx(mapping.get(key), listener, flags);
	}

	@Override
	public void addSubTableListener(ITableListener listener) {
		table.addSubTableListener(listener);
	}

	@Override
	public void addSubTableListener(ITableListener listener, boolean localNotify) {
		table.addSubTableListener(listener, localNotify);
	}

	@Override
	public void removeTableListener(ITableListener listener) {
		table.removeTableListener(listener);
	}

	@Deprecated
	@Override
	public boolean putInt(String key, int value) {
		if (mapping.get(key) == null)
			return false;
		return table.putInt(mapping.get(key), value);
	}

	@Deprecated
	@Override
	public int getInt(String key) throws TableKeyNotDefinedException {
		// TODO Auto-generated method stub
		return table.getInt(mapping.get(key));
	}

	@Deprecated
	@Override
	public int getInt(String key, int defaultValue) throws TableKeyNotDefinedException {
		if (mapping.get(key) == null)
			return defaultValue;
		return table.getInt(mapping.get(key), defaultValue);
	}

	@Deprecated
	@Override
	public boolean putDouble(String key, double value) {
		if (mapping.get(key) == null)
			return false;
		return table.putDouble(mapping.get(key), value);
	}

	@Deprecated
	@Override
	public double getDouble(String key) throws TableKeyNotDefinedException {
		return table.getDouble(mapping.get(key));
	}

	@Deprecated
	@Override
	public double getDouble(String key, double defaultValue) {
		return table.getDouble(mapping.get(key), defaultValue);
	}

}
