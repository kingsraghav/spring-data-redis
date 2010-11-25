/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.keyvalue.redis.core;

import java.util.Set;

/**
 * Default implementation for {@link BoundSetOperations}.
 * 
 * @author Costin Leau
 */
class DefaultBoundSetOperations<K, V> extends DefaultKeyBound<K> implements BoundSetOperations<K, V> {

	private final SetOperations<K, V> ops;


	DefaultBoundSetOperations(K key, RedisTemplate<K, V> template) {
		super(key);
		this.ops = template.setOps();
	}

	@Override
	public Boolean add(V value) {
		return ops.add(getKey(), value);
	}

	@Override
	public Set<V> diff(K... keys) {
		return ops.diff(getKey(), keys);
	}

	@Override
	public void diffAndStore(K destKey, K... keys) {
		ops.diffAndStore(getKey(), destKey, keys);
	}

	@Override
	public RedisOperations<K, V> getOperations() {
		return ops.getOperations();
	}

	@Override
	public Set<V> intersect(K... keys) {
		return ops.intersect(getKey(), keys);
	}

	@Override
	public void intersectAndStore(K destKey, K... keys) {
		ops.intersectAndStore(getKey(), destKey, keys);
	}

	@Override
	public boolean isMember(Object o) {
		return ops.isMember(getKey(), o);
	}

	@Override
	public Set<V> members() {
		return ops.members(getKey());
	}

	@Override
	public boolean remove(Object o) {
		return ops.remove(getKey(), o);
	}

	@Override
	public int size() {
		return ops.size(getKey());
	}

	@Override
	public Set<V> union(K... keys) {
		return ops.union(getKey(), keys);
	}

	@Override
	public void unionAndStore(K destKey, K... keys) {
		ops.unionAndStore(getKey(), destKey, keys);
	}
}