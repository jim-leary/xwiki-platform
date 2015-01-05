/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.mail.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.xwiki.mail.MailState;
import org.xwiki.mail.MailStatus;
import org.xwiki.mail.MailStatusResult;

/**
 * This implementation is not meant for scalability. Don't use it if you're sending a large number of emails. Instead
 * use a Database Mail Listener for example.
 *
 * @version $Id$
 * @since 6.4M3
 */
public class MemoryMailStatusResult implements MailStatusResult
{
    /**
     * The Map's key is the unique message ID.
     */
    private Map<String, MailStatus> statusMap = new HashMap<>();

    public void setStatus(MailStatus status)
    {
        this.statusMap.put(status.getMessageId(), status);
    }

    @Override
    public long getSize()
    {
        return this.statusMap.size();
    }

    @Override
    public Iterator<MailStatus> getAll()
    {
        return this.statusMap.values().iterator();
    }

    @Override
    public Iterator<MailStatus> getByState(MailState state)
    {
        List<MailStatus> results = new ArrayList<>();
        Iterator<MailStatus> iterator = this.statusMap.values().iterator();
        while (iterator.hasNext()) {
            MailStatus status = iterator.next();
            if (MailState.parse(status.getState()).equals(state)) {
                results.add(status);
            }
        }
        return results.iterator();
    }
}
