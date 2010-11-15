package org.nutz.mole.impl;

import java.io.File;
import java.util.List;

import org.nutz.dao.tools.DField;
import org.nutz.dao.tools.DTable;
import org.nutz.dao.tools.Tables;
import org.nutz.lang.Files;
import org.nutz.lang.Strings;

public class Dod2Pojo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String dodDir = "dod";
		if (args.length > 0)
			dodDir = args[0];

		File[] dodFiles = Files.files(Files.findFile(dodDir), ".dod");

		for (File dodFile : dodFiles) {
			List<DTable> tables = Tables.load(dodFile);
			for (DTable table : tables) {
				StringBuilder sb = new StringBuilder();
				String className = table.getName();
				className = className.substring(className.indexOf("_") + 1);
				className = Strings.capitalize(className);
				className = Strings.upperWord(className, '_');
				sb.append("@Table(\"").append(table.getName()).append("\")");
				sb.append("\npublic class ").append(className);
				List<DField> fields = table.getFields();
				for (DField field : fields) {
					if (field.isPrimaryKey()) {
						if (field.getType().startsWith("INT")) {
							sb.append("\n@Id");
						} else {
							sb.append("\n@Name");
						}
					} else {
						sb.append("\n\n@Column(\"" + field.getName() + "\")");
					}
					sb.append("\nprivate ");
					if (field.getType().startsWith("INT")) {
						sb.append("int");
					} else if (field.getType().startsWith("VARCHAR")) {
						sb.append("String");
					} else if (field.getType().startsWith("TIME")) {
						sb.append("Timestamp");
					}
					String fieldName = field.getName();
					if ("ownm".equals(fieldName)) {
						fieldName = "ownerName";
					} else if ("des".equals(fieldName)) {
						fieldName = "description";
					} else if ("ct".equals(fieldName)) {
						fieldName = "createTime";
					} else if ("pvg".equals(fieldName)) {
						fieldName = "privilegeId";
					} else if ("prfid".equals(fieldName)) {
						fieldName = "preferId";
					} else if ("gid".equals(fieldName)) {
						fieldName = "groupId";
					} else if ("tp".equals(fieldName)) {
						fieldName = "type";
					} else if ("sta".equals(fieldName)) {
						fieldName = "status";
					} else if ("lm".equals(fieldName)) {
						fieldName = "lastModified";
					} else if ("pid".equals(fieldName)) {
						fieldName = "parentId";
					}
					sb.append(" ").append(fieldName).append(";");

				}
				sb.append("\n}");
				System.out.println(sb);
				System.out.println(Strings.dup('-', 40));
				System.out.println();
			}
		}
	}

}