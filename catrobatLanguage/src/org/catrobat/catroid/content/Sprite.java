/**
 *  Catroid: An on-device visual programming system for Android devices
 *  Copyright (C) 2010-2013 The Catrobat Team
 *  (<http://developer.catrobat.org/credits>)
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *  
 *  An additional term exception under section 7 of the GNU Affero
 *  General Public License, version 3, is available at
 *  http://developer.catrobat.org/license_additional_term
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Affero General Public License for more details.
 *  
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.catrobat.catroid.content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.catrobat.catroid.common.LookData;
import org.catrobat.catroid.common.SoundInfo;

public class Sprite implements Serializable{

	private static final long serialVersionUID = 1L;

	public String name = "";
	public List<Script> scriptList = new ArrayList<Script>();
	public ArrayList<LookData> lookList = new ArrayList<LookData>();
	public ArrayList<SoundInfo> soundList = new ArrayList<SoundInfo>();

	public boolean equals(Object arg0) {

		if (!(arg0 instanceof Sprite))
			return false;
		Sprite arg = (Sprite) arg0;

		return (name.equals(arg.name) &&
				scriptList.equals(arg.scriptList) &&
				lookList.equals(arg.lookList) &&
				soundList.equals(arg.soundList));
	}
	
	public int hashCode() {
		return name.hashCode();
	}

}